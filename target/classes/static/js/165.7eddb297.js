"use strict";(self["webpackChunkvue_manage"]=self["webpackChunkvue_manage"]||[]).push([[165],{6165:function(t,s,a){a.r(s),a.d(s,{default:function(){return c}});var e=function(){var t=this,s=t._self._c;return s("div",[s("h3",{staticStyle:{}},[t._v(" 欢迎你 "+t._s(this.$store.state.nickname)+" ")]),s("div",{staticClass:"demo-image__placeholder"},[s("div",{staticClass:"block"},[s("span",{staticClass:"demonstration"}),s("el-image",{staticStyle:{width:"20em,",height:"15em"},attrs:{src:t.src,fit:this.fit}},[s("div",{staticClass:"image-slot",attrs:{slot:"placeholder"},slot:"placeholder"},[t._v(" 加载中"),s("span",{staticClass:"dot"},[t._v("...")])]),s("div",{staticClass:"image-slot",attrs:{slot:"error"},slot:"error"},[s("i",{staticClass:"el-icon-picture-outline"})])])],1)]),s("p",[t._v(" "+t._s(t.data.sentence)+" ")]),s("p",{staticStyle:{position:"absolute",right:"1vh"}},[t._v(" ------"+t._s(t.data.author)+" ")]),s("el-button",{attrs:{round:"",id:"btn3"},on:{click:t.startAddGroup}},[t._v(" 开始录入句子或短语 ")]),s("el-button",{attrs:{round:"",id:"btn1"},on:{click:t.startAdd}},[t._v("开始录入单词 ")]),s("el-button",{attrs:{type:"primary",round:"",id:"btn2"},on:{click:t.startRecite}},[t._v("开始背今日内容 ")])],1)},i=[],r=a(9669),o=a.n(r),d={components:{},methods:{startRecite(){this.$router.push("/reciteWords")},startAdd(){this.$router.push("/addWords")},startAddGroup(){this.$router.push("/addGroup")}},name:"MyIndex",data(){return{data:"",src:"",fit:"contain"}},mounted(){null!=this.$store.state.uid&&""!=this.$store.state.uid&&void 0!==this.$store.state.uid||this.$router.push("/login"),o()({method:"post",url:"http://121.40.113.226:7777/getOne",data:{}}).then((t=>{this.data=t.data.data,this.src=this.data.pic}))}},n=d,l=a(1001),u=(0,l.Z)(n,e,i,!1,null,"a5822f0e",null),c=u.exports}}]);
//# sourceMappingURL=165.7eddb297.js.map