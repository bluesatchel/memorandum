"use strict";(self["webpackChunkvue_manage"]=self["webpackChunkvue_manage"]||[]).push([[39],{1039:function(e,t,s){s.r(t),s.d(t,{default:function(){return h}});var a=function(){var e=this,t=e._self._c;return t("div",[t("h1",[e._v("登录界面")]),e._v(" 用户名:"),t("el-input",{attrs:{placeholder:"请输入用户名",clearable:""},model:{value:e.username,callback:function(t){e.username=t},expression:"username"}}),t("br"),t("br"),e._v(" 密码: "),t("el-input",{attrs:{placeholder:"请输入密码","show-password":""},model:{value:e.password,callback:function(t){e.password=t},expression:"password"}}),t("br"),t("br"),t("el-button",{attrs:{type:"primary",plain:"",id:"login"},on:{click:e.login}},[e._v("登录 ")]),t("br"),t("br"),t("br"),t("a",{attrs:{href:"/#/register"},on:{click:e.toRegister}},[e._v("没有账号?立即注册")])],1)},r=[],n=s(9669),o=s.n(n),i={name:"MyLogin",data(){return{username:"",password:""}},methods:{onClickEnter(){this.login()},open1(e){this.$notify({title:"登录成功",message:"欢迎你"+e,type:"success"})},open4(e){this.$notify.error({title:"error",message:e})},toRegister(){this.$router.push("/register")},login(){o()({method:"post",url:"http://121.40.113.226:7777/user/login",data:{username:this.username,password:this.password}}).then((e=>{console.log(e),200==e.data.status?(this.$store.state.uid=e.data.data.uid,this.$store.state.username=e.data.data.username,this.$store.state.nickname=e.data.data.nickname,this.open1(this.$store.state.nickname),this.$router.push("/index")):this.open4("用户名或者密码错误")}))}},mounted(){this.$keyBoard(this,"onClickEnter",13)}},u=i,l=s(1001),d=(0,l.Z)(u,a,r,!1,null,"10b1aaf3",null),h=d.exports}}]);
//# sourceMappingURL=39.d5563c93.js.map