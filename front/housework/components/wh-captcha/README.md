### wh-captcha
#### 使用说明
  | 参数 | 说明 | 默认值 |
  |---|---|---|
  | title | 正常状态下显示标题 | `获取验证码` |
  | waitTitle | 等待状态下显示标题,SECORD为秒数替换 | `稍等（SECORD）秒` |
  | normalClass | 正常状态下样式 | 详见代码 |
  | disabledClass | 等待状态下样式 | 详见代码 |
  | click | 点击事件 | |
#### 示例
  ```html
  <wh-captcha
    ref="captcha"
    :secord="30"
    title="获取验证码"
    waitTitle="稍等(SECORD)秒"
    normalClass="captcha-normal"
    disabledClass="captcha-disabled"
    @click="getCaptcha"
  ></wh-captcha>
  ```