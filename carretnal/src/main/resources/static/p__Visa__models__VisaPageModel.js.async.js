(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[46],{"p/du":function(e,a,t){"use strict";t.r(a);var s=t("d6i3"),r=t.n(s),n=t("p0pE"),i=t.n(n),p=t("bmkC"),l=t("QArB"),u=t("SlhZ");a["default"]={namespace:"visapage",state:{pageName:"",descr:"",elements:[]},effects:{fetch:r.a.mark(function e(a,t){var s,n,c,o,d,f,m,g;return r.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return s=a.payload,n=t.call,c=t.put,e.next=4,n(l["a"],s);case 4:for(o=e.sent,d=Object(u["a"])(o),f=d.elements,m=0;m<f.length;m+=1){g=f[m];try{g.rules=g.rules?JSON.parse(g.rules):"",g.options=g.options?JSON.parse(g.options):"",g.displayWhen=g.displayWhen?JSON.parse(g.displayWhen):"",g.disableWhen=g.disableWhen?JSON.parse(g.disableWhen):""}catch(e){p["message"].error(e.toString())}}return e.next=10,c({type:"getPage",payload:i()({},d)});case 10:case"end":return e.stop()}},e)}),save:r.a.mark(function e(a,t){var s,n,i,c,o,d,f,m,g,h,y,v,b;return r.a.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return s=a.payload,n=a.callback,i=t.call,c=t.put,o=s.pageId,d=s.prjId,f=s.values,m=s.elementsMap,g=s.isComplete,h=[],Object.keys(f).forEach(function(e){var a=f[e];if(m[e]&&f[e]){var t=m[e].type;if(20===t)a=JSON.stringify(f[e].tableData);else if(4===t)a=f[e].format("YYYY-MM-DD");else if(5===t)a=f[e].format("HHmmss");else if(8===t){var s=f[e].map(function(e){return e.format("YYYY-MM-DD")});a=JSON.stringify(s)}else if(11===t)a=JSON.stringify(f[e]);else if(9===t)a=JSON.stringify(f[e]);else if(12===t||13===t){var r=f[e];if(r&&r.length>0){var n=r.map(function(e){return{uid:e.uid,name:e.name,status:e.status,url:e.url,thumbUrl:e.thumbUrl}});a=JSON.stringify(n)}else a=null}}h.push({pageElemId:e,value:a,storageId:m[e].storageId})}),e.next=7,i(l["d"],{id:o,prjId:d,data:h,isComplete:g});case 7:return y=e.sent,v=g,b=!0,Object(u["b"])(y)?p["message"].success("\u4fdd\u5b58\u6210\u529f"):(p["message"].error("\u4fdd\u5b58\u5931\u8d25:".concat(y.msg)),v=!1,b=!1),e.next=13,c({type:"visaform/updateFinSts",payload:{finished:v,pageId:o}});case 13:n&&n(b);case 14:case"end":return e.stop()}},e)})},reducers:{getPage:function(e,a){return i()({},e,a.payload)}}}}}]);