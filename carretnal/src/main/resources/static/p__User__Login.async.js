(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[37],{JAxp:function(e,t,a){e.exports={login:"antd-pro-components-login-index-login",getCaptcha:"antd-pro-components-login-index-getCaptcha",icon:"antd-pro-components-login-index-icon",other:"antd-pro-components-login-index-other",register:"antd-pro-components-login-index-register",prefixIcon:"antd-pro-components-login-index-prefixIcon",submit:"antd-pro-components-login-index-submit"}},Y5yc:function(e,t,a){"use strict";a.r(t);a("Pwec");var n=a("CtXQ"),r=(a("sRBo"),a("kaz8")),o=(a("fOrg"),a("+KLJ")),i=a("p0pE"),s=a.n(i),c=a("2Taf"),l=a.n(c),p=a("vZ4D"),u=a.n(p),m=a("l4Ni"),d=a.n(m),g=a("ujKo"),h=a.n(g),f=a("MhPg"),b=a.n(f),v=a("q1tI"),y=a.n(v),C=a("MuoO"),E=a("Y2fQ"),x=a("mOP9"),w=(a("y8nQ"),a("Vl3Y")),M=(a("Znn+"),a("ZTPi")),N=a("gWZ8"),S=a.n(N),T=(a("17x9"),a("TSYQ")),O=a.n(T),j=(a("14J3"),a("BMrR")),k=(a("+L6B"),a("2/Rp")),P=(a("jCWc"),a("kPKH")),q=(a("5NDa"),a("5rEg")),I=a("jehZ"),F=a.n(I),A=a("Y/ft"),D=a.n(A),G=a("QbLZ"),L=a.n(G);function B(e,t){for(var a=L()({},e),n=0;n<t.length;n++){var r=t[n];delete a[r]}return a}var z=B,K=a("JAxp"),U=a.n(K),J={UserName:{props:{size:"large",id:"userName",prefix:y.a.createElement(n["a"],{type:"user",className:U.a.prefixIcon}),placeholder:"admin"},rules:[{required:!0,message:"Please enter username!"}]},Password:{props:{size:"large",prefix:y.a.createElement(n["a"],{type:"lock",className:U.a.prefixIcon}),type:"password",id:"password",placeholder:"888888"},rules:[{required:!0,message:"Please enter password!"}]},Mobile:{props:{size:"large",prefix:y.a.createElement(n["a"],{type:"mobile",className:U.a.prefixIcon}),placeholder:"mobile number"},rules:[{required:!0,message:"Please enter mobile number!"},{pattern:/^1\d{10}$/,message:"Wrong mobile number format!"}]},Captcha:{props:{size:"large",prefix:y.a.createElement(n["a"],{type:"mail",className:U.a.prefixIcon}),placeholder:"captcha"},rules:[{required:!0,message:"Please enter Captcha!"}]}},Z=Object(v["createContext"])(),Q=Z,V=w["a"].Item,Y=function(e){function t(e){var a;return l()(this,t),a=d()(this,h()(t).call(this,e)),a.onGetCaptcha=function(){var e=a.props.onGetCaptcha,t=e?e():null;!1!==t&&(t instanceof Promise?t.then(a.runGetCaptchaCountDown):a.runGetCaptchaCountDown())},a.getFormItemOptions=function(e){var t=e.onChange,a=e.defaultValue,n=e.customprops,r=e.rules,o={rules:r||n.rules};return t&&(o.onChange=t),a&&(o.initialValue=a),o},a.runGetCaptchaCountDown=function(){var e=a.props.countDown,t=e||59;a.setState({count:t}),a.interval=setInterval(function(){t-=1,a.setState({count:t}),0===t&&clearInterval(a.interval)},1e3)},a.state={count:0},a}return b()(t,e),u()(t,[{key:"componentDidMount",value:function(){var e=this.props,t=e.updateActive,a=e.name;t&&t(a)}},{key:"componentWillUnmount",value:function(){clearInterval(this.interval)}},{key:"render",value:function(){var e=this.state.count,t=this.props.form.getFieldDecorator,a=this.props,n=(a.onChange,a.customprops),r=(a.defaultValue,a.rules,a.name),o=a.getCaptchaButtonText,i=a.getCaptchaSecondText,s=(a.updateActive,a.type),c=D()(a,["onChange","customprops","defaultValue","rules","name","getCaptchaButtonText","getCaptchaSecondText","updateActive","type"]),l=this.getFormItemOptions(this.props),p=c||{};if("Captcha"===s){var u=z(p,["onGetCaptcha","countDown"]);return y.a.createElement(V,null,y.a.createElement(j["a"],{gutter:8},y.a.createElement(P["a"],{span:16},t(r,l)(y.a.createElement(q["a"],F()({},n,u)))),y.a.createElement(P["a"],{span:8},y.a.createElement(k["a"],{disabled:e,className:U.a.getCaptcha,size:"large",onClick:this.onGetCaptcha},e?"".concat(e," ").concat(i):o))))}return y.a.createElement(V,null,t(r,l)(y.a.createElement(q["a"],F()({},n,p))))}}]),t}(v["Component"]);Y.defaultProps={getCaptchaButtonText:"captcha",getCaptchaSecondText:"second"};var W={};Object.keys(J).forEach(function(e){var t=J[e];W[e]=function(a){return y.a.createElement(Q.Consumer,null,function(n){return y.a.createElement(Y,F()({customprops:t.props,rules:t.rules},a,{type:e,updateActive:n.updateActive,form:n.form}))})}});var R=W,$=M["a"].TabPane,H=function(){var e=0;return function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:"";return e+=1,"".concat(t).concat(e)}}(),X=function(e){function t(e){var a;return l()(this,t),a=d()(this,h()(t).call(this,e)),a.uniqueId=H("login-tab-"),a}return b()(t,e),u()(t,[{key:"componentDidMount",value:function(){var e=this.props.tabUtil;e.addTab(this.uniqueId)}},{key:"render",value:function(){var e=this.props.children;return y.a.createElement($,this.props,e)}}]),t}(v["Component"]),_=function(e){return y.a.createElement(Q.Consumer,null,function(t){return y.a.createElement(X,F()({tabUtil:t.tabUtil},e))})};_.typeName="LoginTab";var ee=_,te=w["a"].Item,ae=function(e){var t=e.className,a=D()(e,["className"]),n=O()(U.a.submit,t);return y.a.createElement(te,null,y.a.createElement(k["a"],F()({size:"large",className:n,type:"primary",htmlType:"submit"},a)))},ne=ae,re=function(e){function t(e){var a;return l()(this,t),a=d()(this,h()(t).call(this,e)),a.onSwitch=function(e){a.setState({type:e});var t=a.props.onTabChange;t(e)},a.getContext=function(){var e=a.state.tabs,t=a.props.form;return{tabUtil:{addTab:function(t){a.setState({tabs:[].concat(S()(e),[t])})},removeTab:function(t){a.setState({tabs:e.filter(function(e){return e!==t})})}},form:t,updateActive:function(e){var t=a.state,n=t.type,r=t.active;r[n]?r[n].push(e):r[n]=[e],a.setState({active:r})}}},a.handleSubmit=function(e){e.preventDefault();var t=a.state,n=t.active,r=t.type,o=a.props,i=o.form,s=o.onSubmit,c=n[r];i.validateFields(c,{force:!0},function(e,t){s(e,t)})},a.state={type:e.defaultActiveKey,tabs:[],active:{}},a}return b()(t,e),u()(t,[{key:"render",value:function(){var e=this.props,t=e.className,a=e.children,n=this.state,r=n.type,o=n.tabs,i=[],s=[];return y.a.Children.forEach(a,function(e){e&&("LoginTab"===e.type.typeName?i.push(e):s.push(e))}),y.a.createElement(Q.Provider,{value:this.getContext()},y.a.createElement("div",{className:O()(t,U.a.login)},y.a.createElement(w["a"],{onSubmit:this.handleSubmit},o.length?y.a.createElement(y.a.Fragment,null,y.a.createElement(M["a"],{animated:!1,className:U.a.tabs,activeKey:r,onChange:this.onSwitch},i),s):a)))}}]),t}(v["Component"]);re.defaultProps={className:"",defaultActiveKey:"",onTabChange:function(){},onSubmit:function(){}},re.Tab=ee,re.Submit=ne,Object.keys(R).forEach(function(e){re[e]=R[e]});var oe,ie,se,ce=w["a"].create()(re),le=a("w2qy"),pe=a.n(le),ue=ce.Tab,me=ce.UserName,de=ce.Password,ge=ce.Mobile,he=ce.Captcha,fe=ce.Submit,be=(oe=Object(C["connect"])(function(e){var t=e.login,a=e.loading;return{login:t,submitting:a.effects["login/login"]}}),oe((se=function(e){function t(){var e,a;l()(this,t);for(var n=arguments.length,r=new Array(n),i=0;i<n;i++)r[i]=arguments[i];return a=d()(this,(e=h()(t)).call.apply(e,[this].concat(r))),a.state={type:"account",autoLogin:!0},a.onTabChange=function(e){a.setState({type:e})},a.onGetCaptcha=function(){return new Promise(function(e,t){a.loginForm.validateFields(["mobile"],{},function(n,r){if(n)t(n);else{var o=a.props.dispatch;o({type:"login/getCaptcha",payload:r.mobile}).then(e).catch(t)}})})},a.handleSubmit=function(e,t){var n=a.state.type;if(!e){var r=a.props.dispatch;r({type:"login/login",payload:s()({},t,{type:n})})}},a.changeAutoLogin=function(e){a.setState({autoLogin:e.target.checked})},a.renderMessage=function(e){return y.a.createElement(o["a"],{style:{marginBottom:24},message:e,type:"error",showIcon:!0})},a}return b()(t,e),u()(t,[{key:"render",value:function(){var e=this,t=this.props,a=t.login,o=t.submitting,i=this.state,s=i.type,c=i.autoLogin;return y.a.createElement("div",{className:pe.a.main},y.a.createElement(ce,{defaultActiveKey:s,onTabChange:this.onTabChange,onSubmit:this.handleSubmit,ref:function(t){e.loginForm=t}},y.a.createElement(ue,{key:"account",tab:Object(E["formatMessage"])({id:"app.login.tab-login-credentials"})},"error"===a.status&&"account"===a.type&&!o&&this.renderMessage(Object(E["formatMessage"])({id:"app.login.message-invalid-credentials"})),y.a.createElement(me,{name:"userName",placeholder:"".concat(Object(E["formatMessage"])({id:"app.login.userName"}),": admin or user"),rules:[{required:!0,message:Object(E["formatMessage"])({id:"validation.userName.required"})}]}),y.a.createElement(de,{name:"password",placeholder:"".concat(Object(E["formatMessage"])({id:"app.login.password"}),": ant.design"),rules:[{required:!0,message:Object(E["formatMessage"])({id:"validation.password.required"})}],onPressEnter:function(t){t.preventDefault(),e.loginForm.validateFields(e.handleSubmit)}})),y.a.createElement(ue,{key:"mobile",tab:Object(E["formatMessage"])({id:"app.login.tab-login-mobile"})},"error"===a.status&&"mobile"===a.type&&!o&&this.renderMessage(Object(E["formatMessage"])({id:"app.login.message-invalid-verification-code"})),y.a.createElement(ge,{name:"mobile",placeholder:Object(E["formatMessage"])({id:"form.phone-number.placeholder"}),rules:[{required:!0,message:Object(E["formatMessage"])({id:"validation.phone-number.required"})},{pattern:/^1\d{10}$/,message:Object(E["formatMessage"])({id:"validation.phone-number.wrong-format"})}]}),y.a.createElement(he,{name:"captcha",placeholder:Object(E["formatMessage"])({id:"form.verification-code.placeholder"}),countDown:120,onGetCaptcha:this.onGetCaptcha,getCaptchaButtonText:Object(E["formatMessage"])({id:"form.get-captcha"}),getCaptchaSecondText:Object(E["formatMessage"])({id:"form.captcha.second"}),rules:[{required:!0,message:Object(E["formatMessage"])({id:"validation.verification-code.required"})}]})),y.a.createElement("div",null,y.a.createElement(r["a"],{checked:c,onChange:this.changeAutoLogin},y.a.createElement(E["FormattedMessage"],{id:"app.login.remember-me"})),y.a.createElement("a",{style:{float:"right"},href:""},y.a.createElement(E["FormattedMessage"],{id:"app.login.forgot-password"}))),y.a.createElement(fe,{loading:o},y.a.createElement(E["FormattedMessage"],{id:"app.login.login"})),y.a.createElement("div",{className:pe.a.other},y.a.createElement(E["FormattedMessage"],{id:"app.login.sign-in-with"}),y.a.createElement(n["a"],{type:"alipay-circle",className:pe.a.icon,theme:"outlined"}),y.a.createElement(n["a"],{type:"taobao-circle",className:pe.a.icon,theme:"outlined"}),y.a.createElement(n["a"],{type:"weibo-circle",className:pe.a.icon,theme:"outlined"}),y.a.createElement(x["a"],{className:pe.a.register,to:"/user/register"},y.a.createElement(E["FormattedMessage"],{id:"app.login.signup"})))))}}]),t}(v["Component"]),ie=se))||ie);t["default"]=be},w2qy:function(e,t,a){e.exports={main:"antd-pro-pages-user-login-main",icon:"antd-pro-pages-user-login-icon",other:"antd-pro-pages-user-login-other",register:"antd-pro-pages-user-login-register"}}}]);