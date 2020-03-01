const api = 'http://127.0.0.1:8080';

/* 首页轮播图 */
export const carouselList = [{
		src: "http://127.0.0.1:8080/housework/lunbo/lunbo1.png",
		background: "rgb(203, 87, 60)",
	},
	{
		src: "http://127.0.0.1:8080/housework/lunbo/lunbo.png",
		background: "rgb(205, 215, 218)",
	},
	{
		src: "http://127.0.0.1:8080/housework/jiadian/1xyj.png",
		background: "rgb(183, 73, 69)",
	}
]

/* 精品推荐 */
export const recommendurl = api + '/service/recommend';
/* 服务列表 */
export const listurl = api + '/service/list';
/* 单个服务详情 */
export const detailurl = api + '/service/detail';

/* 登录和注册 */
export const loginurl = api + '/user/login';
export const registerurl = api + '/user/register';
export const uidurl = api + '/user/uid';

/* 收藏 */
export const collectionaddurl = api + '/collection/add';
export const collectionreduceurl = api + '/collection/reduce';
export const collectionlisturl = api + '/collection/list';
export const collectionisurl = api + '/collection/isCollection';

/* 地址 */
export const addressaddurl = api + '/address/add';
export const defaultaddraddurl = api + '/defaulraddr/add';
export const addresslisturl = api + '/address/list';
export const defaultaddrlisturl = api + '/defaulraddr/check';
export const addresupdateurl = api + '/address/update';
//获取默认地址
export const defaultaddrdetailurl = api + '/defaulraddr/detail';

/* 订单 */
export const orderaddurl = api + '/order/add';
export const orderlisturl = api + '/order/list/';

/* 客服 */
export const robottalkurl = api + '/robot/talk';

/* 获取验证码 */
export const getVeriCode = api + '/user/getvericode/';

export const cateList = [{
		id: 1,
		name: '家电清洗'
	},
	{
		id: 2,
		name: '居家保姆'
	},
	{
		id: 3,
		name: '家居保洁'
	},
	{
		id: 4,
		name: '家电维修'
	}
]

export const myrequest = function(url, method, data) {
	if (data != null || data != undefined || data != {}) {
		Object.keys(data).forEach(function(key) {
			url += '/' + data[key];
		});
	}
	console.log(url);
	return new Promise((resolve, reject) => {
		uni.request({
			url: url,
			method: method,
			header: {
				'custom-header': 'housework'
			},
			success: (res) => {
				resolve(res.data);
			},
			fail: (err) => {
				reject(err.data);
				console.log("获取数据失败");
			}
		});
	});
};

export const myget = function(name) {
	return new Promise((resolve, reject) => {
		uni.getStorage({
			key: name,
			success: function(res) {
				resolve(res.data);
			},
			fail: (err) => {
				reject(err.data);
				console.log("获取数据失败");
			}
		});
	});
}
export const myshowModal = function(name) {
	return new Promise((resolve, reject) => {
		uni.showModal({
			title: '购买',
			content: '确定预定该服务吗',
			success: function(res) {
				if (res.confirm) {
					resolve(true);
				} else if (res.cancel) {
					reject(false);
				}
			}
		});
	});
}
