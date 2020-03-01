<template>
	<view class="page">
		<view class="message-height">
			<view v-for="(it,i) in messageData" :key="i">
				<left-message v-if="it.type == -1" :data="it.message"></left-message>
				<view class="jiange"></view>
				<right-message v-if="it.type == 1" :data="it.message"></right-message>
			</view>
		</view>
		<view class="footer">
			<view class="send-message">
				<view class="input-wrapper"><input type="text" cursor-spacing ="0" adjust-position="true" v-model="message"></view>
				<view class="iconfont ic_open" @click="send">发送</view>
			</view>
		</view>
	</view>
</template>

<script>
	import leftMessage from "../../components/left-message.vue";
	import rightMessage from "../../components/right-message.vue";
	import { robottalkurl, myrequest } from '../../api.js';
	export default {
		components: {
			leftMessage,
			rightMessage,
		},
		data() {
			return {
				//-1为客服消息,1为我发送的消息
				messageData: [{
						"type": -1,
						"message": "你好，很高心为您服务，请输入关键词‘家电清洗’、‘保姆’、‘家居保洁’、‘家电维修’、‘商城’、‘客服’、‘付款声明’，了解详情"
					},
				],
				message: "",
				pageHeight: 0,
				windowHeight: 0
			};
		},
		onReady() {
			let _this = this;
			uni
				.createSelectorQuery()
				.selectAll(".page")
				.boundingClientRect(function(rects) {
					_this.pageHeight = rects[0].height;
					uni.pageScrollTo({
						scrollTop: rects[0].height - _this.windowHeight,
						duration: 0
					});
				})
				.exec();
		},
		onLoad() {
			let _this = this;
			uni.getSystemInfo({
				success: function(res) {
					_this.windowHeight = res.windowHeight;
				}
			});
			uni.onWindowResize(res => {
				uni.pageScrollTo({
					scrollTop: _this.pageHeight - res.size.windowHeight,
					duration: 300
				});
			});
		},
		methods: {
			async send(){
				this.messageData.push({ type: 1, message: this.message });
				const data = await myrequest(robottalkurl, 'GET', { word : this.message });
				this.messageData.push({ type: -1, message: data.data.talk });
			},
		}
	};
</script>

<style lang="scss" scoped="true">
	.page {
		box-sizing: border-box;
		width: 100%;
		overflow: hidden;
		padding-bottom: 100upx;
	}
	.jiange{
		border-top: 3px solid transparent; 
	}

	.messagelist {
		.message-height {
			padding: 30upx 0 130upx 0;
		}
	}

	.footer {
		position: fixed;
		bottom: 0;
		left: 0;
		width: 100%;
		height: 100upx;
	}	
	.send-message{
		box-sizing: border-box;
		padding: 0 15upx;
		height: 100upx;
		width: 100%;
		background:#4191ea;
		line-height: 100upx;
		display: flex;
		flex-wrap: nowrap;
		.iconfont{
			width: 120upx;
			font-size: 3px;
			text-align: center;
			line-height: 100upx;
			flex: 0 0 auto;
			color: #fff;
			font-size: 60upx;
		}
		.input-wrapper{
			flex:1;
			padding: 10upx;
			input{
				box-sizing: border-box;
				padding: 0 15upx;
				width: 100%;
				height: 100%;
				border-radius: 10upx;
				background: #fff;
			}
		}
	}
</style>
