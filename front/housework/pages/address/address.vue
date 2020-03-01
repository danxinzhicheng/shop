<template>
	<view class="content b-t">
		<view class="list b-b" v-for="(item, index) in addressList" :key="index" @click="checkAddress(item)">
			<view class="wrapper">
				<view class="address-box">
					<text v-if="item.default" class="tag">默认</text>
					<text class="address">{{item.address}} {{item.area}}</text>
				</view>
				<view class="u-box">
					<text class="name">{{item.name}}</text>
					<text class="mobile">{{item.mobile}}</text>
				</view>
			</view>
			<text class="yticon icon-bianji"></text>
		</view>

		<button class="add-btn" @click="addAddress()">新增地址</button>
	</view>
</template>

<script>
	import Vue from 'vue';
	import {
		myrequest,
		addresslisturl,
		myget,
		defaultaddrlisturl
	} from '../../api.js';
	export default {
		data() {
			return {
				uid: "",
				addressList: []
			}
		},
		async onLoad() {
			this.uid = await myget('uid');
			let data = await myrequest(addresslisturl, 'GET', {
				uid: this.uid
			});
			this.addressList = data["data"];
			let aid = await myrequest(defaultaddrlisturl, 'GET', {
				uid: this.uid
			});
			await this.addressList.forEach(function(item, index) {
				if (item.id === aid["data"]["aid"]) {
					Vue.set(item, 'default', true);
				} else {
					Vue.set(item, 'default', false);
				}
			});
		},
		async onShow() {
			this.uid = await myget('uid');
			let data = await myrequest(addresslisturl, 'GET', {
				uid: this.uid
			});
			this.addressList = data["data"];
			let aid = await myrequest(defaultaddrlisturl, 'GET', {
				uid: this.uid
			});
			await this.addressList.forEach(function(item, index) {
				if (item.id === aid["data"]["aid"]) {
					Vue.set(item, 'default', true);
				} else {
					Vue.set(item, 'default', false);
				}
			});
		},
		methods: {
			checkAddress(options) {
				uni.navigateTo({
					url: `/pages/address/addressEdit?options=${JSON.stringify(options)}`
				})
			},
			addAddress() {
				uni.navigateTo({
					url: '/pages/address/addressManage',
				})
			}
		}
	}
</script>

<style lang='scss'>
	page {
		padding-bottom: 120upx;
	}

	.content {
		position: relative;
	}

	.list {
		display: flex;
		align-items: center;
		padding: 20upx 30upx;
		;
		background: #fff;
		position: relative;
	}

	.wrapper {
		display: flex;
		flex-direction: column;
		flex: 1;
	}

	.address-box {
		display: flex;
		align-items: center;

		.tag {
			font-size: 24upx;
			color: $base-color;
			margin-right: 10upx;
			background: #fffafb;
			border: 1px solid #ffb4c7;
			border-radius: 4upx;
			padding: 4upx 10upx;
			line-height: 1;
		}

		.address {
			font-size: 30upx;
			color: $font-color-dark;
		}
	}

	.u-box {
		font-size: 28upx;
		color: $font-color-light;
		margin-top: 16upx;

		.name {
			margin-right: 30upx;
		}
	}

	.icon-bianji {
		display: flex;
		align-items: center;
		height: 80upx;
		font-size: 40upx;
		color: $font-color-light;
		padding-left: 30upx;
	}

	.add-btn {
		position: fixed;
		left: 30upx;
		right: 30upx;
		bottom: 16upx;
		z-index: 95;
		display: flex;
		align-items: center;
		justify-content: center;
		width: 690upx;
		height: 80upx;
		font-size: 32upx;
		color: #fff;
		background-color: $base-color;
		border-radius: 10upx;
		box-shadow: 1px 2px 5px rgba(219, 63, 96, 0.4);
	}
</style>
