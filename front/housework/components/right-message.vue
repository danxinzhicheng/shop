<template>
	<view class="right-message">
		<view class="bubble-wrapper">
			<div class="bubble">
				<rich-text :nodes="data"></rich-text>
			</div>
			<view class="time">{{time}}</view>
		</view>
		<view class="avator-wrapper">
			<view class="avator">
				<img src="/static/missing-face.png" class="img">
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		name: 'right-message',
		props: {
			data: String,//聊天内容
			time: String,//提取名称的一个字
		}
	}
</script>

<style lang="scss" scoped="true">
	.right-message{
		display:flex;
		padding-right: 20upx;
	}
	.avator-wrapper{
		flex: 0 0 auto;
	}
	.bubble-wrapper{
		padding-left: 135upx;
		flex: 1;
		padding-right: 30upx;
		.bubble{
			padding: 20upx;
			background: #d5ebff;
			border-radius:15upx;
			position: relative;
			&::before{
				position:absolute;
				right: -20upx;
				top: 10upx;
				content: "";
				width: 0; 
				height: 0; 
				border-top: 20px solid transparent; 
				border-left: 20px solid #d5ebff; 
				border-bottom: 20px solid transparent; 
			}
		}
	}
	.avator{
		width: 100upx;
		height: 100upx;
		border-radius: 50%;
		overflow: hiideen;
		background: #f1f1f1;
		.img{
			width:100%;
			height: 100%;
			border-radius: 50%;
		}
	}
	.time{
		line-height: 50upx;
		color:#b7b7b7;
		font-size: 24upx;
	}
</style>