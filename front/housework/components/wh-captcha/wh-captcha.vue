<template>
  <button type="default" plain="true" @click="clickAction" :class="[state === 'normal' ? normalClass : disabledClass]">{{ state === 'normal' ? title : waitTitle.replace('SECORD', currSecord) }}</button>
</template>

<script>
/*
 * 获取验证码组件
 * @param title 正常状态下显示文字
 * @param waitTitle 等待状态下的显示文字，文字中需要包含SECORD字段以替换倒计时秒数
 * @param secord 等待时长
 * @param normalClass 正常状态下样式
 * @param disabledClass 禁用状态下样式
 */
export default {
  props: {
    title: {
      type: String,
      default: '获取验证码'
    },
    waitTitle: {
      type: String,
      default: '稍等（SECORD）秒'
    },
    secord: {
      type: Number,
      default: 60
    },
    normalClass: {
      type: String,
      default: 'normal'
    },
    disabledClass: {
      type: String,
      default: 'disabled'
    }
  },
  data() {
    return {
      state: 'normal',
      currSecord: 0
    };
  },
  methods: {
    clickAction() {
      this.$emit('click');
    },
    canSend() {
      return this.state === 'normal';
    },
    begin() {
      this.currSecord = this.secord;
      this.state = 'wait';
      this.beginInterval();
    },
    beginInterval() {
      this.currSecord = this.currSecord - 1;
      if (this.currSecord <= 0) {
        this.state = 'normal';
      } else {
        setTimeout(this.beginInterval, 1000);
      }
    }
  }
};
</script>

<style scoped>
.normal {
  background: rgba(246, 246, 246, 1);
  width: 219upx;
  height: 76upx;
  line-height: 76upx;
  border-radius: 10upx;
  border: 2upx solid rgba(63, 67, 70, 1);
  font-size: 28upx;
  font-weight: 400;
  color: rgba(27, 27, 27, 1);
  text-align: center;
}
.disabled {
  background: rgba(246, 246, 246, 1);
  width: 219upx;
  height: 76upx;
  line-height: 76upx;
  border-radius: 10upx;
  font-size: 28upx;
  font-weight: 400;
  text-align: center;
  color: rgba(127, 127, 127, 1);
  border-color: rgba(127, 127, 127, 1);
}
</style>
