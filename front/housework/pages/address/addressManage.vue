<template>
	<view class="content">
		<view class="row b-b">
			<text class="tit">联系人</text>
			<input class="input" type="text" v-model="addressData.name" placeholder="收货人姓名" placeholder-class="placeholder" />
		</view>
		<view class="row b-b">
			<text class="tit">手机号</text>
			<input class="input" type="number" v-model="addressData.mobile" placeholder="收货人手机号码" placeholder-class="placeholder" />
		</view>
		<view class="row b-b">
			<text class="tit">地址</text>
			<text @click="chooseLocation" class="input">
				{{addressData.addressName}}
			</text>
			<text class="yticon icon-shouhuodizhi"></text>
		</view>
		<view class="row b-b">
			<text class="tit">门牌号</text>
			<input class="input" type="text" v-model="addressData.area" placeholder="楼号、门牌" placeholder-class="placeholder" />
		</view>

		<view class="row default-row">
			<text class="tit">设为默认</text>
			<switch :checked="addressData.default" color="#fa436a" @change="switchChange" />
		</view>
		<button class="add-btn" @click="confirm">提交</button>
	</view>
</template>

<script>
	import {
		myget,
		myrequest,
		addressaddurl,
		defaultaddraddurl
	} from '../../api.js';
	export default {
		data() {
			return {
				addressData: {
					uid: '',
					name: '',
					mobile: '',
					addressName: '在地图选择',
					area: '',
					default: false
				},
			}
		},
		async onLoad(option) {
			let title = '新增收货地址';
			uni.setNavigationBarTitle({
				title
			})
			this.addressData.mobile = await myget('mobile');
		},
		methods: {
			switchChange(e) {
				this.addressData.default = e.detail.value;
			},

			//地图选择地址
			chooseLocation() {
				uni.chooseLocation({
					success: (data) => {
						this.addressData.addressName = data.name;
					}
				})
			},

			//提交
			async confirm() {
				let data = this.addressData;
				if (!data.name) {
					uni.showToast({
						title: '请填写收货人姓名',
						icon: 'none',
					});
					return;
				}
				if (!/(^1[3|4|5|7|8][0-9]{9}$)/.test(data.mobile)) {
					uni.showToast({
						title: '请输入正确的手机号码',
						icon: 'none',
					});
					return;
				}
				if (!data.addressName) {
					uni.showToast({
						title: '请输入正确的手机号码',
						icon: '请在地图选择所在位置',
					});
					return;
				}
				if (!data.area) {
					uni.showToast({
						title: '请填写门牌号信息',
						icon: 'none',
					});
					return;
				}
				this.addressData.uid = await myget('uid');
				console.log(this.addressData);
				await myrequest(addressaddurl, 'POST', this.addressData);
				uni.navigateBack();
			},
		}
	}
</script>

<style lang="scss">
	page {
		background: $page-color-base;
		padding-top: 16upx;
	}

	.row {
		display: flex;
		align-items: center;
		position: relative;
		padding: 0 30upx;
		height: 110upx;
		background: #fff;

		.tit {
			flex-shrink: 0;
			width: 120upx;
			font-size: 30upx;
			color: $font-color-dark;
		}

		.input {
			flex: 1;
			font-size: 30upx;
			color: $font-color-dark;
		}

		.icon-shouhuodizhi {
			font-size: 36upx;
			color: $font-color-light;
		}
	}

	.default-row {
		margin-top: 16upx;

		.tit {
			flex: 1;
		}

		switch {
			transform: translateX(16upx) scale(.9);
		}
	}

	.add-btn {
		display: flex;
		align-items: center;
		justify-content: center;
		width: 690upx;
		height: 80upx;
		margin: 60upx auto;
		font-size: $font-lg;
		color: #fff;
		background-color: $base-color;
		border-radius: 10upx;
		box-shadow: 1px 2px 5px rgba(219, 63, 96, 0.4);
	}
</style>
