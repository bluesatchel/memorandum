(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-e53d09ea"],{c771:function(t,s,e){},d0d3:function(t,s,e){"use strict";e.r(s);var a=function(){var t=this,s=t._self._c;return s("div",[s("van-nav-bar",{attrs:{title:"背忘录"}}),s("div",{staticClass:"all"},[s("div",{staticClass:"value"}),s("h3",[t._v("请输入单词")]),s("van-field",{model:{value:t.textarea,callback:function(s){t.textarea=s},expression:"textarea"}}),s("div",{staticClass:"wrap"},[this.addWordList.length?s("div",{staticClass:"left"},[s("h5",[t._v("录入的单词")]),t._l(this.addWordList,(function(e,a){return s("ul",{key:a,attrs:{id:"addWordList"}},[s("li",[t._v(t._s(e))])])}))],2):t._e()]),s("van-button",{attrs:{plain:"",type:"info",id:"btn3"},on:{click:t.addWord}},[t._v("录入 ")])],1)],1)},i=[],d=e("bc3a"),o=e.n(d),r=e("d399"),n={name:"AddWords",data(){return{textarea:"",success:!1,word:"",addWordList:[]}},methods:{onClickLeft(){Object(r["a"])("返回"),history.go(-1)},onClickRight(){Object(r["a"])("按钮")},onClickEnter(){this.addWord()},open4(t){this.$notify.error({title:"warning",message:t,type:"warning"})},addWord(){let t=/^[A-Za-z\x20\x2d]+$/;""==this.textarea||null==this.textarea?(this.open4("请输入内容"),this.textarea=""):t.test(this.textarea)?o()({method:"post",url:this.$baseURL+"/word/addWord",data:{uid:this.$store.state.uid,value:this.textarea}}).then(t=>{200==t.data.status?(this.success=!0,this.word=this.textarea,this.addWordList.unshift(this.word),console.log(this.addWordList),this.open1(this.word),this.textarea=""):(this.success=!1,this.textarea="",this.open4(t.data.message))}):(this.open4("请输入单词"),this.textarea="")},open1(t){this.$notify({title:"添加成功",message:"单词"+t+"添加成功",type:"success",position:"bottom-right"})}},mounted(){this.$keyBoard(this,"onClickEnter",13),null!=this.$store.state.uid&&""!=this.$store.state.uid&&void 0!==this.$store.state.uid||(alert("请先登录"),this.$router.push("/phone/login"))}},h=n,l=(e("efb2"),e("2877")),c=Object(l["a"])(h,a,i,!1,null,"83876654",null);s["default"]=c.exports},efb2:function(t,s,e){"use strict";e("c771")}}]);
//# sourceMappingURL=chunk-e53d09ea.2686365a.js.map