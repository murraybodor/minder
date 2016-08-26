
/*

  SmartClient Ajax RIA system
  Version SC_SNAPSHOT-2010-08-03/EVAL Development Only (2010-08-03)

  Copyright 2000 and beyond Isomorphic Software, Inc. All rights reserved.
  "SmartClient" is a trademark of Isomorphic Software, Inc.

  LICENSE NOTICE
     INSTALLATION OR USE OF THIS SOFTWARE INDICATES YOUR ACCEPTANCE OF
     ISOMORPHIC SOFTWARE LICENSE TERMS. If you have received this file
     without an accompanying Isomorphic Software license file, please
     contact licensing@isomorphic.com for details. Unauthorized copying and
     use of this software is a violation of international copyright law.

  DEVELOPMENT ONLY - DO NOT DEPLOY
     This software is provided for evaluation, training, and development
     purposes only. It may include supplementary components that are not
     licensed for deployment. The separate DEPLOY package for this release
     contains SmartClient components that are licensed for deployment.

  PROPRIETARY & PROTECTED MATERIAL
     This software contains proprietary materials that are protected by
     contract and intellectual property law. You are expressly prohibited
     from attempting to reverse engineer this software or modify this
     software for human readability.

  CONTACT ISOMORPHIC
     For more information regarding license rights and restrictions, or to
     report possible license violations, please contact Isomorphic Software
     by email (licensing@isomorphic.com) or web (www.isomorphic.com).

*/

if(window.isc&&window.isc.module_Core&&!window.isc.module_RealtimeMessaging){isc.module_RealtimeMessaging=1;isc._moduleStart=isc._RealtimeMessaging_start=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc._moduleEnd&&(!isc.Log||(isc.Log && isc.Log.logIsDebugEnabled('loadTime')))){isc._pTM={ message:'RealtimeMessaging load/parse time: ' + (isc._moduleStart-isc._moduleEnd) + 'ms', category:'loadTime'};
if(isc.Log && isc.Log.logDebug)isc.Log.logDebug(isc._pTM.message,'loadTime')
else if(isc._preLog)isc._preLog[isc._preLog.length]=isc._pTM
else isc._preLog=[isc._pTM]}isc.definingFramework=true;isc.ClassFactory.defineClass("Messaging");isc.A=isc.Messaging;isc.A.messagingURL="[ISOMORPHIC]/messaging";isc.A.$zq=1;isc.A.$zr=null;isc.A.$zs=null;isc.A._channels={};isc.A.$zt=[];isc.A.$zu=20;isc.A.connectTimeout=4000;isc.A=isc.Messaging;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.send=function isc_c_Messaging_send(_1,_2,_3){if(!isc.isAn.Array(_1))_1=[_1];isc.rpc.app().performOperation("messagingSend",{type:"send",sendToChannels:_1,subscribedChannels:this._channels,data:_2},"isc.Messaging.$zv(rpcResponse)",{showPrompt:false,callback:_3,willHandleError:_3!=null})}
,isc.A.$zv=function isc_c_Messaging__sendCallback(_1){}
,isc.A.getSubscribedChannels=function isc_c_Messaging_getSubscribedChannels(){return isc.getKeys(this._channels)}
,isc.A.subscribe=function isc_c_Messaging_subscribe(_1,_2,_3){if(!this._channels[_1]){this._channels[_1]={};if(_3)this._channels[_1].data=_3;this.$zw()}
this._channels[_1].callback=_2;return}
,isc.A.unsubscribe=function isc_c_Messaging_unsubscribe(_1){if(!this._channels[_1])return;delete this._channels[_1];this.$zw();if(isc.isAn.emptyObject(this._channels))this.disconnect()}
,isc.A.connected=function isc_c_Messaging_connected(){return this._channels&&isc.getKeys(this._channels).length>0&&this.$zx}
,isc.A.disconnect=function isc_c_Messaging_disconnect(){this._channels={};this.$zr=null;this.$zs=null;this.$zy=null;isc.Timer.clear(this.$zz);this.$zz=null;isc.Timer.clear(this.$z0);this.$z0=null}
,isc.A.$zw=function isc_c_Messaging__reconnect(){if(!isc.Page.isLoaded()){isc.Page.setEvent("load","isc.Messaging.$zw()");return}
if(!this.$zz)
this.$zz=isc.Timer.setTimeout("isc.Messaging.$z1()",this.$zq,isc.Timer.MSEC)}
,isc.A.$z2=function isc_c_Messaging__connectRetry(){if(this.$zs&&window[this.$zs])window[this.$zs].destroy();this.$zs=null;this.logDebug("connect failed, retrying in: "+this.connectTimeout+"ms");this.$zw()}
,isc.A._serverConnTerminate=function isc_c_Messaging__serverConnTerminate(){this.$zw()}
,isc.A.$z1=function isc_c_Messaging__connect(){isc.Timer.clear(this.$zz);this.$zz=null;if(this.$zs){this.$z3=true;this.logDebug("connect pending - deferring openConnection request.");return}
if(this.getSubscribedChannels().length==0)return;var _1=isc.HiddenFrame.create();this.$zs=_1.getID();var _2={type:"connect",connectionID:this.$zs,subscribedChannels:isc.Comm.serialize(this._channels)}
isc.Comm.sendHiddenFrame({URL:isc.Page.getURL(this.messagingURL)+"?ts="+isc.timestamp(),fields:_2,transaction:{changed:function(){},requestData:_2},frame:_1});this.$z4=isc.Timer.setTimeout("isc.Messaging.$z2()",this.connectTimeout,isc.Timer.MSEC)}
,isc.A._connectCallback=function isc_c_Messaging__connectCallback(_1,_2){if(_1!=this.$zs)return;this.$z5=_2.keepaliveInterval;this.$z6=_2.keepaliveReestablishDelay;this.$z7=this.$z5+this.$z6;this.$z8=_2.connectionTTL;this.connectTimeout=_2.connectTimeout;if(this.$zr&&window[this.$zr])window[this.$zr].destroy();this.$zr=this.$zs;this.$zs=null;isc.Timer.clear(this.$z4);this.$z9();this.$0a();this.logDebug("persistent server connection open - ttl: "+this.$z8+"ms, keepaliveDelay: "+this.$z7+"ms, connectTimeout: "+this.connectTimeout+"ms.")
if(this.$z3){this.$z3=false;this.$zw();return}
var _3=isc.HiddenFrame.create();var _4=_3.getID();var _5={type:"establishAck",ackFrameID:_4};isc.Comm.sendHiddenFrame({URL:isc.Page.getURL(this.messagingURL)+"?ts="+isc.timestamp(),fields:_5,transaction:{changed:function(){},requestData:_5},frame:_3})}
,isc.A.$z9=function isc_c_Messaging__resetStatusBar(){var _1=isc.Browser.isIE?"Done":"Stopped";isc.Timer.setTimeout("window.status='"+_1+"'",0)}
,isc.A._establishAck=function isc_c_Messaging__establishAck(_1){if(_1&&window[_1])window[_1].destroy();this.$zx=true}
,isc.A._keepalive=function isc_c_Messaging__keepalive(_1){this.$z9();if(_1!=this.$zr)return;this.$0a();this.logDebug("keepalive on conn: "+_1)}
,isc.A.$0b=function isc_c_Messaging__keepaliveWatchdog(){this.logDebug("connection to server lost, re-establishing...");this.$zw()}
,isc.A.$0a=function isc_c_Messaging__resetKeepaliveTimer(){isc.Timer.clear(this.$z0);this.$z0=isc.Timer.setTimeout("isc.Messaging.$0b()",this.$z7,isc.Timer.MSEC)}
,isc.A._message=function(message){message=isc.eval("var message = "+message+";message;");var conn=message.conn,channels=message.channels,id=message.id,data=message.data;this.$z9();if(conn!=this.$zr)return;this.$0a();if(this.$zt.contains(id)){this.logDebug("ignoring duplicate ID: "+id);return}
this.$zt.push(id);if(this.$zt.length>this.$zu)this.$zt.shift();for(var i=0;i<channels.length;i++){var channel=channels[i];if(!this._channels[channel])continue;var channel=this._channels[channel],callback=channel.callback
if(callback)this.fireCallback(callback,"data",[data],channel)}}
,isc.A.$74q=function isc_c_Messaging__destroyConns(){if(this.$zs!=null&&window[this.$zs]!=null){window[this.$zs].destroy()}
if(this.$zr!=null&&window[this.$zr]!=null){window[this.$zr].destroy()}
delete this.$zr;delete this.$zs}
);isc.B._maxIndex=isc.C+19;isc.Page.setEvent("unload","isc.Messaging.$74q()");isc._moduleEnd=isc._RealtimeMessaging_end=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc.Log&&isc.Log.logIsInfoEnabled('loadTime'))isc.Log.logInfo('RealtimeMessaging module init time: ' + (isc._moduleEnd-isc._moduleStart) + 'ms','loadTime');delete isc.definingFramework;}else{if(window.isc && isc.Log && isc.Log.logWarn)isc.Log.logWarn("Duplicate load of module 'RealtimeMessaging'.");}

/*

  SmartClient Ajax RIA system
  Version SC_SNAPSHOT-2010-08-03/EVAL Development Only (2010-08-03)

  Copyright 2000 and beyond Isomorphic Software, Inc. All rights reserved.
  "SmartClient" is a trademark of Isomorphic Software, Inc.

  LICENSE NOTICE
     INSTALLATION OR USE OF THIS SOFTWARE INDICATES YOUR ACCEPTANCE OF
     ISOMORPHIC SOFTWARE LICENSE TERMS. If you have received this file
     without an accompanying Isomorphic Software license file, please
     contact licensing@isomorphic.com for details. Unauthorized copying and
     use of this software is a violation of international copyright law.

  DEVELOPMENT ONLY - DO NOT DEPLOY
     This software is provided for evaluation, training, and development
     purposes only. It may include supplementary components that are not
     licensed for deployment. The separate DEPLOY package for this release
     contains SmartClient components that are licensed for deployment.

  PROPRIETARY & PROTECTED MATERIAL
     This software contains proprietary materials that are protected by
     contract and intellectual property law. You are expressly prohibited
     from attempting to reverse engineer this software or modify this
     software for human readability.

  CONTACT ISOMORPHIC
     For more information regarding license rights and restrictions, or to
     report possible license violations, please contact Isomorphic Software
     by email (licensing@isomorphic.com) or web (www.isomorphic.com).

*/

