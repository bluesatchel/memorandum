(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-50950b96"],{1396:function(t,s,e){},2121:function(t,s,e){"use strict";e("571e")},2329:function(t,s,e){"use strict";e("1396")},"571e":function(t,s,e){},"5bba":function(t,s,e){"use strict";e.r(s);var i=function(){var t=this,s=t._self._c;return s("div",{staticClass:"all"},[s("van-nav-bar",{attrs:{title:"标题","left-text":"返回","right-text":"待定","left-arrow":""},on:{"click-left":t.onClickLeft,"click-right":t.onClickRight}}),s("van-button",{staticClass:"mark",attrs:{plain:"",type:"danger",size:"small"},on:{click:t.markWord}},["0"==t.wordList[t.n].marked?s("div",[t._v("标记")]):s("div",[t._v("取消标记")])]),s("el-checkbox",{attrs:{id:"english"},model:{value:t.displayEnglish,callback:function(s){t.displayEnglish=s},expression:"displayEnglish"}},[t._v("英 ")]),s("el-checkbox",{attrs:{id:"chinese"},model:{value:t.displayChinese,callback:function(s){t.displayChinese=s},expression:"displayChinese"}},[t._v("中 ")]),t.isSentense?t._e():s("el-card",[t.displayEnglish?s("div",{staticClass:"value"},[s("p",{attrs:{id:"word"}},[t._v(" "+t._s(t.wordInfo.word)+" ")])]):t._e(),t.displayEnglish?t._e():s("div",{staticClass:"value"},[s("p",{attrs:{id:"word"}},[t._v("*")])]),s("div",{staticClass:"announce"},[t._v(" 英式读音 "),s("van-icon",{attrs:{name:""}}),t._v(" "+t._s(t.wordInfo.uk_phonetic)+" "),s("van-button",{attrs:{type:"info",size:"mini",icon:"volume-o"},on:{click:t.ukSpeech}}),s("br"),t._v(" 美式读音 "+t._s(t.wordInfo.us_phonetic)+" "),s("van-button",{attrs:{type:"info",size:"mini",icon:"volume-o"},on:{click:t.usSpeech}})],1),s("h3",[t._v("释义")]),t.displayChinese?s("div",[s("div",{staticClass:"explains"},t._l(t.wordInfo.explains,(function(e,i){return s("ul",{key:i},[s("li",[t._v(" "+t._s(e)+" ")])])})),0),t.wordInfo.wordGroup.length?s("div",[s("h3",[t._v("词组")]),t._l(t.wordInfo.wordGroup,(function(e,i){return s("ul",{key:i},[s("li",[t._v(" "+t._s(e)+" ")])])}))],2):t._e(),this.flag?t._e():s("div",[s("h3",[t._v("网络释义及词组")]),t._l(t.wordInfo.web,(function(e,i){return s("ul",{key:i},[s("li",[t._v(" "+t._s(e.key)+" "+t._s(e.value)+" ")])])}))],2),t.wordInfo.sentences.length?s("div",[s("h3",[t._v("双语例句")]),t._l(t.wordInfo.sentences,(function(e,i){return s("ul",{key:i},[s("li",[t._v(" "+t._s(e.en)+" "+t._s(e.cn)+" ")])])}))],2):t._e()]):t._e()]),t.isSentense?s("el-card",[s("h2",[t._v("句子")]),t.displayEnglish?s("h4",[t._v(" "+t._s(t.sentence.query)+" ")]):t._e(),s("br"),s("h2",[t._v("释义")]),t.displayChinese?s("h4",[t._v(" "+t._s(t.sentence.translation)+" ")]):t._e(),s("el-button",{ref:"uk",attrs:{type:"primary",plain:"",icon:"el-icon-service",size:"mini"},on:{click:t.sentenseSpeech}})],1):t._e(),s("p",{attrs:{id:"index"},on:{click:t.jump}},[t._v(t._s(t.n+1)+"/"+t._s(t.wordList.length))]),s("van-button",{attrs:{plain:"",id:"btn1",type:"info",size:"small"},on:{click:t.previous}},[t._v("上一个 ")]),s("van-button",{attrs:{plain:"",id:"btn2",type:"info",size:"small"},on:{click:t.next}},[t._v("下一个 ")])],1)},n=[],o=e("bc3a"),r=e.n(o),a=e("f564"),h=e("d399"),l={name:"MyWords",data(){return{currentWord:"",wordList:[],wordInfo:{sentences:[],wordGroup:[],uk_phonetic:"",us_phonetic:"",word:"",explains:[],web:[]},phoneticArr:[],basic:{},arr:[],keyArr:[],flag:!0,isSentense:!1,sentence:{},n:0,displayEnglish:!0,displayChinese:!0,hasCustomTranslation:!1}},methods:{onClickLeft(){Object(h["a"])("返回"),history.go(-1)},onClickRight(){Object(h["a"])("按钮")},markWord(){r()({method:"post",url:this.$baseURL+"/word/mark",data:{wid:this.wordList[this.n].wid}}).then(t=>{200==t.data.status?(1==this.wordList[this.n].marked?this.wordList[this.n].marked=0:this.wordList[this.n].marked=1,Object(a["a"])({type:"success",message:t.data.message})):Object(a["a"])({type:"danger",message:"标记失败"})})},jump(){this.open()},open(){this.$prompt("请输入要跳转的index","提示",{confirmButtonText:"确定",cancelButtonText:"取消",inputPattern:/[0-9]+/,inputErrorMessage:"格式不正确,请输入纯数字"}).then(({value:t})=>{this.$message({type:"success",message:"跳转到"+t}),t>this.wordList.length&&t>=0?this.$message({type:"warning",message:"out of range!"}):(this.n=t-1,this.getWordInfo(this.wordList[this.n].value))}).catch(()=>{this.$message({type:"info",message:"取消输入"})})},open2(t){this.$message({showClose:!0,message:t,type:"success"})},isEmpty(t){return null==t||""==t||void 0==t},getWordInfo(t){this.isSentense=!1,r()({method:"post",url:this.$baseURL+"/word/getWordInfo",data:{value:t}}).then(t=>{400==t.data.status?(this.flag=!1,this.getFromYouDao(this.wordList[this.n].value),this.wordInfo.sentences=[],this.wordInfo.wordGroup=[]):(this.flag=!0,console.log(t),this.wordInfo=t.data.data,this.isEmpty(this.wordList[this.n].customTranslation)||this.wordInfo.explains.unshift(this.wordList[this.n].customTranslation))})},next(){this.n<this.wordList.length-1?(this.n++,this.getWordInfo(this.wordList[this.n].value)):this.open2("已经是最后一个单词了,今日共背了"+this.wordList.length+"个")},previous(){0==this.n?this.open2("已经到头了"):this.n>0&&(this.n--,-1!=this.n&&this.getWordInfo(this.wordList[this.n].value))},ukSpeech(){this.flag?this.FileukSpeech():this.YDukSpeech()},usSpeech(){this.flag?this.FileusSpeech():this.YDusSpeech()},FileukSpeech(){let t=new Audio;t.src="http://121.40.113.226/audio/"+this.wordInfo.word+"_uk.mp3",t.play()},FileusSpeech(){let t=new Audio;t.src="http://121.40.113.226/audio/"+this.wordInfo.word+"_us.mp3",t.play()},getFromYouDao(t){let s="mtKD1CVzlGrj2rcSxK4DzTPz9m4zRscM",e="50649feb1569418e",i=(new Date).getTime(),n=Date.parse(new Date)/1e3;r()({method:"post",url:this.$baseURL+"/api/",headers:{"content-type":"application/x-www-form-urlencoded"},data:this.$qs.stringify({q:t,from:"en",to:"zh-CHS",salt:i,curtime:n,appKey:e,sign:this.$sha256(e+this.truncate(t)+i+n+s),signType:"v3",ext:"mp3",voice:"0",strict:"true"})}).then(s=>{if(console.log(s.data),0==s.data.isWord)this.isSentense=!0,this.sentence.query=s.data.query,this.sentence.translation=s.data.translation,this.isEmpty(this.wordList[this.n].customTranslation)||(this.sentence.translation=this.wordList[this.n].customTranslation),this.sentence.speakUrl=s.data.speakUrl;else{this.isSentense=!1,this.basic=s.data.basic,this.arr=Object.values(this.basic),this.keyArr=Object.keys(this.basic);let e=0;for(e;e<this.keyArr.length;e++)if("uk-phonetic"==this.keyArr[e])break;this.phoneticArr[0]=this.arr[e];let i=0;for(i;i<this.keyArr.length;i++)if("us-phonetic"==this.keyArr[i])break;this.phoneticArr[1]=this.arr[i],console.log(this.phoneticArr),this.wordInfo.uk_phonetic=this.phoneticArr[0],this.wordInfo.us_phonetic=this.phoneticArr[1],this.wordInfo.sentences=[],this.wordInfo.word=t,this.wordInfo.explains=this.basic.explains,this.isEmpty(this.wordList[this.n].customTranslation)||this.wordInfo.explains.unshift(this.wordList[this.n].customTranslation),this.wordInfo.wordGroup=[],this.wordInfo.web=s.data.web,console.log(this.wordInfo)}})},truncate(t){let s=t.length;return s<=20?t:t.substring(0,10)+s+t.substring(s-10,s)},YDukSpeech(){let t=new Audio,s=0;for(s;s<this.keyArr.length;s++)if("uk-speech"==this.keyArr[s])break;t.src=this.arr[s],t.play()},YDusSpeech(){let t=new Audio,s=0;for(s;s<this.keyArr.length;s++)if("us-speech"==this.keyArr[s])break;t.src=this.arr[s],t.play()},finished(t){alert("今天背了"+t+"条")},sentenseSpeech(){let t=new Audio;t.src=this.sentence.speakUrl,t.play()}},mounted(){null!=this.$store.state.uid&&""!=this.$store.state.uid&&void 0!==this.$store.state.uid||(alert("请先登录"),this.$router.push("/phone/login"));let t=Array.from(this.$route.query.data);this.wordList=t,this.n=0,this.getWordInfo(this.wordList[0].value)}},c=l,d=(e("2121"),e("2329"),e("2877")),u=Object(d["a"])(c,i,n,!1,null,"d50596ce",null);s["default"]=u.exports}}]);
//# sourceMappingURL=chunk-50950b96.29450970.js.map