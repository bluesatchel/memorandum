"use strict";(self["webpackChunkvue_manage"]=self["webpackChunkvue_manage"]||[]).push([[292],{6292:function(t,a,e){e.r(a),e.d(a,{default:function(){return h}});var s=function(){var t=this,a=t._self._c;return a("div",[t._v(" 注:该页面还需后面再优化,先把数据摆上来 "),t._l(t.data,(function(e){return a("ul",{key:e.id},[a("li",[t._v(t._s(e.value)+"                              "+t._s(e.year)+"-"+t._s(e.month)+"-"+t._s(e.day)+" ")])])}))],2)},u=[],n=e(9669),r=e.n(n),l={name:"allWordList",data(){return{data:[]}},mounted(){null!=this.$store.state.uid&&""!=this.$store.state.uid&&void 0!==this.$store.state.uid||(alert("请先登录"),this.$router.push("/login")),r()({method:"post",url:"http://121.40.113.226:7778/word/allWords",data:{uid:this.$store.state.uid}}).then((t=>{this.data=t.data.data,0==this.data.length&&alert("还没有添加单词哦,先去添加单词吧")}))}},d=l,i=e(1001),o=(0,i.Z)(d,s,u,!1,null,null,null),h=o.exports}}]);
//# sourceMappingURL=292.b1890e54.js.map