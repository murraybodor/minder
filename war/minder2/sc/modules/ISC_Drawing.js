
/*

  SmartClient Ajax RIA system
  Version SC_SNAPSHOT-2010-08-03/EVAL Deployment (2010-08-03)

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

if(window.isc&&window.isc.module_Core&&!window.isc.module_Drawing){isc.module_Drawing=1;isc._moduleStart=isc._Drawing_start=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc._moduleEnd&&(!isc.Log||(isc.Log && isc.Log.logIsDebugEnabled('loadTime')))){isc._pTM={ message:'Drawing load/parse time: ' + (isc._moduleStart-isc._moduleEnd) + 'ms', category:'loadTime'};
if(isc.Log && isc.Log.logDebug)isc.Log.logDebug(isc._pTM.message,'loadTime')
else if(isc._preLog)isc._preLog[isc._preLog.length]=isc._pTM
else isc._preLog=[isc._pTM]}isc.definingFramework=true;isc.Browser.hasCANVAS=isc.Browser.geckoVersion>=20051107||isc.Browser.safariVersion>=181;isc.Browser.hasSVG=isc.Browser.geckoVersion>=20051107;isc.Browser.hasVML=isc.Browser.isIE&&isc.Browser.version>=5;isc.Browser.defaultDrawingType=isc.Browser.hasVML?"vml":isc.Browser.hasCANVAS?"bitmap":"none";isc.defineClass("DrawPane","Canvas");isc.A=isc.DrawPane.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.drawingType=isc.Browser.defaultDrawingType;isc.A.isMouseTransparent=true;isc.A.zoomLevel=1;isc.A.canDrag=true;isc.A.cursor="all-scroll";isc.B.push(isc.A.initWidget=function isc_DrawPane_initWidget(){if(!this.drawItems)this.drawItems=[];if(!this.canvasItems)this.canvasItems=[];for(var i=0;i<this.drawItems.length;i++){this.addDrawItem(this.drawItems[i])}
for(var i=0;i<this.canvasItems.length;i++){this.addCanvasItem(this.canvasItems[i])}
this.redrawOnResize=(this.drawingType=="bitmap");this.$43z=this.getInnerContentWidth();this.$430=this.getInnerContentHeight();this.$431=0;this.$432=0;this.$433=this.$43z;this.$434=this.$430;if(this.shouldShowEventMask()){this.addChild(isc.Canvas.create({width:"100%",height:"100%",drawPane:this,autoDraw:false,canDrag:this.canDrag,dragAppearance:"none",cursor:this.cursor,dragStart:function(){this.totalPanDeltaX=0;this.totalPanDeltaY=0},dragMove:function(){var _2=isc.EH.lastEvent.x-isc.EH.mouseDownEvent.x,_3=isc.EH.lastEvent.y-isc.EH.mouseDownEvent.y;this.drawPane.pan(this.totalPanDeltaX-_2,this.totalPanDeltaY-_3)
this.totalPanDeltaX=_2;this.totalPanDeltaY=_3}}))}}
,isc.A.shouldShowEventMask=function isc_DrawPane_shouldShowEventMask(){return true}
,isc.A.erase=function isc_DrawPane_erase(){for(var i=0;i<this.drawItems.length;i++){this.drawItems[i].erase(true)}
this.drawItems=[];this.canvasItems=[];if(this.drawingType=="bitmap")this.redrawBitmap()}
,isc.A.addDrawItem=function isc_DrawPane_addDrawItem(_1,_2){if(_1.drawPane==this)return;if(_1.$if)_1.erase();_1.drawPane=this;if(!this.drawItems.contains(_1))this.drawItems.add(_1);if(_2==null)_2=true;if(_2&&this.isDrawn()){_1.draw()}}
,isc.A.getInnerHTML=function isc_DrawPane_getInnerHTML(){var _1=this.drawingType;if(_1=="vml"){return"<VML:GROUP ID='"+this.getID()+"$435' STYLE='position:absolute; left:0; top:0; "+"width:"+this.getInnerContentWidth()+"; height:"+this.getInnerContentHeight()+";' COORDSIZE='"+this.getInnerContentWidth()+" "+this.getInnerContentHeight()+"' COORDORIGIN='0 0'></VML:GROUP>"}else if(_1=="bitmap"){return"<CANVAS ID='"+this.getID()+"$436'"+" WIDTH='"+this.getWidth()+"' HEIGHT='"+this.getHeight()+"'></CANVAS>"}else if(_1=="svg"){return"<IFRAME HEIGHT='100%' WIDTH='100%' SCROLLING='NO' FRAMEBORDER='0' SRC='"+isc.Page.getHelperDir()+"DrawPane.svg?isc_dp_id="+this.getID()+"'></IFRAME>"}else{this.logWarn("DrawPane getInnerHTML: '"+_1+"' is not a supported drawingType");return this.Super("getInnerHTML",arguments)}}
,isc.A.drawChildren=function isc_DrawPane_drawChildren(){this.Super("drawChildren",arguments);for(var i=0;i<this.drawItems.length;i++){this.drawItems[i].draw()}}
,isc.A.getBitmapContext=function isc_DrawPane_getBitmapContext(){if(this.$437)return this.$437;this.$438=isc.Element.get(this.getID()+"$436");if(!this.$438){this.logWarn("DrawPane failed to get CANVAS element handle");return}
this.$437=this.$438.getContext("2d");if(!this.$437){this.logWarn("DrawPane failed to get CANVAS 2d bitmap context");return}
return this.$437}
,isc.A.redraw=function isc_DrawPane_redraw(_1){if(this.drawingType=="bitmap"){this.Super("redraw",arguments);this.$437=null}}
,isc.A.redrawBitmap=function isc_DrawPane_redrawBitmap(){if(this.$439)return;isc.Timer.setTimeout({target:this,methodName:"redrawBitmapNow"},0);this.$439=true}
,isc.A.redrawBitmapNow=function isc_DrawPane_redrawBitmapNow(){this.$439=false;var _1=this.getBitmapContext();if(!_1)return;_1.clearRect(0,0,this.getWidth(),this.getHeight());for(var i=0;i<this.drawItems.length;i++){if(!this.drawItems[i].hidden)this.drawItems[i].drawBitmap(_1)}}
,isc.A.drawing2screen=function isc_DrawPane_drawing2screen(_1){return[Math.round((_1[0]-this.$431)*this.zoomLevel),Math.round((_1[1]-this.$432)*this.zoomLevel),Math.round(_1[2]*this.zoomLevel),Math.round(_1[3]*this.zoomLevel)]}
,isc.A.screen2drawing=function(screenRect){return[screenRect[0]/this.zoomLevel+this.$431,screenRect[1]/this.zoomLevel+this.$432,screenRect[2]/this.zoomLevel,screenRect[3]/this.zoomLevel]}
,isc.A.$44a=function isc_DrawPane__setViewBox(_1,_2,_3,_4){var _5=this.drawingType;this.$431=_1;this.$432=_2;this.$433=_3;this.$434=_4;this.$44b();if(_5=="vml"){if(!this.$44c)this.$44c=isc.Element.get(this.getID()+"$435");this.$44c.coordorigin.x=_1;this.$44c.coordorigin.y=_2;this.$44c.coordsize.x=_3;this.$44c.coordsize.y=_4}else if(_5=="svg"){this.$44d.setAttributeNS(null,"viewBox",_1+" "+_2+" "+_3+" "+_4)}}
,isc.A.addCanvasItem=function isc_DrawPane_addCanvasItem(_1){this.canvasItems.add(_1);_1.drawPane=this;_1.$44e=_1.left;_1.$44f=_1.top;_1.$44g=_1.width;_1.$44h=_1.height;this.addChild(_1);this.$44i(_1);return _1}
,isc.A.$44i=function isc_DrawPane__updateCanvasItemToViewBox(_1){_1.synchingToPane=true;_1.setRect(this.drawing2screen([_1.$44e,_1.$44f,_1.$44g,_1.$44h]));if(_1.drawBorderSize){_1.getStyleHandle().borderWidth=Math.max(1,_1.drawBorderSize*this.zoomLevel)+"px"}
delete _1.synchingToPane}
,isc.A.$44b=function isc_DrawPane__updateItemsToViewBox(){for(var i=0,_2;i<this.canvasItems.length;i++){this.$44i(this.canvasItems[i])}
if(this.drawingType=="vml"){for(var i=0,_3,_4;i<this.drawItems.length;i++){_3=this.drawItems[i];if(isc.isA.DrawLabel(_3)){_3.$44j.fontSize=_3.$44k*this.zoomLevel;if(!_3.synchTextMove){_4=this.drawing2screen([_3.left,_3.top,0,0]);_3.$44j.left=_4[0];_3.$44j.top=_4[1]}}else{_3.$44l(_3.lineWidth*this.zoomLevel)}}}}
,isc.A.pan=function isc_DrawPane_pan(_1,_2){this.$44a(this.$431+_1/ this.zoomLevel,this.$432+_2/ this.zoomLevel,this.$433,this.$434)}
,isc.A.zoom=function isc_DrawPane_zoom(_1){var _2=_1/ this.zoomLevel,_3=this.$433/ _2,_4=this.$434/ _2;this.zoomLevel=_1;this.$44a(this.$431+this.$433/ 2-_3/ 2,this.$432+this.$434/ 2-_4/ 2,_3,_4)}
,isc.A.shouldDeferDrawing=function isc_DrawPane_shouldDeferDrawing(_1){if(this.drawingType=="svg"&&!this.$44m){if(!this.$63q){this.$63q=[_1]}else{this.$63q.add(_1)}
return true}
return false}
,isc.A.cancelDeferredDraw=function isc_DrawPane_cancelDeferredDraw(_1){if(this.$63q&&this.$63q.contains(_1)){this.$63q.remove(_1);return true}
return false}
,isc.A.svgLoaded=function isc_DrawPane_svgLoaded(){this.$44m=this.getHandle().firstChild.contentDocument;this.$44d=this.$44m.getElementById("isc_svg_body");this.$44n=this.$44m.getElementById("isc_svg_box");this.$44o=this.$44m.getElementById("isc_svg_defs");if(this.$63q){this.$63q.map("draw");delete this.$63q}}
);isc.B._maxIndex=isc.C+21;isc.A=isc.DrawPane;isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.$44p=[];isc.A.defaultDrawingType=isc.Browser.defaultDrawingType;isc.B.push(isc.A.getDefaultDrawPane=function isc_c_DrawPane_getDefaultDrawPane(_1){if(!_1)_1=this.defaultDrawingType;if(this.$44p[_1])return this.$44p[_1];var _2=this.$44p[_1]=this.create({drawingType:_1,width:isc.Page.getScrollWidth(),height:isc.Page.getScrollHeight(),autoDraw:true});_2.sendToBack();return _2}
);isc.B._maxIndex=isc.C+1;isc.defineClass("DrawItem").addClassProperties({$44q:0,$630:["show",,"Knobs"],$631:["hide",,"Knobs"],$632:function(_1,_2){if(!this.$633){this.$633={}}
if(this.$633[_1]==null){_1=_1.substring(0,1).toUpperCase()+_1.substring(1);this.$630[1]=_1;this.$631[1]=_1;this.$633[_1]=[this.$630.join(isc.emptyString),this.$631.join(isc.emptyString)]}
return _2?this.$633[_1][1]:this.$633[_1][0]}})
isc.A=isc.DrawItem.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.lineWidth=3;isc.A.lineColor="#808080";isc.A.lineOpacity=1.0;isc.A.linePattern="solid";isc.A.lineCap="round";isc.A.fillOpacity=1.0;isc.A.moveKnobPoint="TL";isc.A.resizeKnobPoints=["TL","TR","BL","BR"];isc.A.$44r={shortdot:1,dot:1,shortdash:3,dash:4,longdash:8};isc.A.$44s={shortdot:1,dot:3,shortdash:1,dash:3,longdash:3};isc.B.push(isc.A.init=function isc_DrawItem_init(){this.Super("init");if(this.ID==null||window[this.ID]!=this){isc.ClassFactory.addGlobalID(this)}
this.drawItemID=isc.DrawItem.$44q++;if(this.autoDraw)this.draw()}
,isc.A.draw=function isc_DrawItem_draw(){if(this.$if){this.logWarn("DrawItem already drawn - exiting draw()");return}
if(this.drawGroup){if(!this.drawGroup.$if){this.logWarn("Attempted draw into an undrawn group - calling draw() on the group now");this.drawGroup.draw();if(!this.drawGroup.$if)return}
this.drawPane=this.drawGroup.drawPane}else{if(!this.drawPane)this.drawPane=isc.DrawPane.getDefaultDrawPane(this.drawingType)}
var _1=this.drawPane;if(!_1||!_1.isDrawn()){return}
if(_1.shouldDeferDrawing(this))return;var _2=this.drawingType=_1.drawingType;if(_2=="vml"){this.drawingVML=true}else if(_2=="svg"){this.drawingSVG=true}else if(_2=="bitmap"){this.drawingBitmap=true}
if(this.drawingVML){if(isc.isA.DrawLabel(this)&&!this.synchTextMove){this.$44t=_1.getHandle()}else if(this.drawGroup){this.$44t=this.drawGroup.$44u}else{this.$44t=isc.Element.get(_1.getID()+"$435")}
var _3="isc_DrawItem_"+this.drawItemID;isc.Element.insertAdjacentHTML(this.$44t,this.drawToBack?"afterBegin":"beforeEnd",this.$44v(_3));this.$44u=isc.Element.get(_3);if(!isc.isA.DrawGroup(this)&&!isc.isA.DrawImage(this)&&!isc.isA.DrawLabel(this)){this.$44w=this.$44u.firstChild;this.$44x=this.$44w.nextSibling}
if(isc.isA.DrawLabel(this)){if(this.synchTextMove){this.$44j=this.$44u.firstChild.style}else{this.$44j=this.$44u.style}}}else if(this.drawingSVG){this.$44m=_1.getHandle().firstChild.contentDocument;this.$44y=this.drawGroup?this.drawGroup.$44z:this.$44m.getElementById("isc_svg_box");if(this.$44y==null){this.logWarn("DrawItem.draw() - Attempt to render into drawPane using svg unable to"+" access svgContainer - svg frame may not have loaded.");return}
this.$44o=this.$44m.getElementById("isc_svg_defs");var _3="isc_DrawItem_"+this.drawItemID;var _4=this.$44m.createRange();_4.setStart(this.$44y,0);var _5=_4.createContextualFragment(this.$440(_3));if(this.drawToBack&&this.$44y.firstChild){this.$44y.insertBefore(_5,this.$44y.firstChild);this.$44z=this.$44y.firstChild}else{this.$44y.appendChild(_5);this.$44z=this.$44y.lastChild}}else if(this.drawingBitmap){_1.redrawBitmap()}else{this.logWarn("DrawItem: '"+_2+"' is not a supported drawingType");return}
if(this.drawGroup)this.drawGroup.drawItems.add(this);else _1.drawItems.add(this);this.$if=true;if(this.knobs){for(var i=0;i<this.knobs.length;i++)this.$634(this.knobs[i])}}
,isc.A.moved=function isc_DrawItem_moved(_1,_2){this.updateControlKnobs()}
,isc.A.resized=function isc_DrawItem_resized(_1,_2){this.updateControlKnobs()}
,isc.A.$634=function isc_DrawItem__showKnobs(_1){var _2=isc.DrawItem.$632(_1)
if(!this[_2]){this.logWarn("DrawItem specfied with knobType:"+_1+" but no "+_2+" function exists to show the knobs. Ignoring")}else{this[_2]()}}
,isc.A.$635=function isc_DrawItem__hideKnobs(_1){var _2=isc.DrawItem.$632(_1,true)
if(!this[_2]){this.logWarn("DrawItem specfied with knobType:"+_1+" but no "+_2+" function exists to hide the knobs.")}else{this[_2]()}}
,isc.A.showKnobs=function isc_DrawItem_showKnobs(_1){if(isc.isAn.Array(_1)){for(var i=0;i<_1.length;i++){this.showKnobs(_1[i])}
return}
if(!this.knobs)this.knobs=[];if(this.knobs.contains(_1))return;this.knobs.add(_1);if(this.$if){this.$634(_1)}}
,isc.A.hideKnobs=function isc_DrawItem_hideKnobs(_1){if(!this.knobs)return;if(isc.isAn.Array(_1)){for(var i=0;i<_1.length;i++){this.hideKnobs(_1[i])}
return}
if(this.knobs.contains(_1))this.knobs.remove(_1);if(this.$if){this.$635(_1)}}
,isc.A.$636=function isc_DrawItem__getKnobPosition(_1){var x,y;x=_1.contains("L")?this.left:(_1.contains("R")?(this.left+this.width):(this.left+Math.round(this.width/ 2)));y=_1.contains("T")?this.top:(_1.contains("B")?(this.top+this.height):(this.top+Math.round(this.height/ 2)));return[x,y]}
,isc.A.showMoveKnobs=function isc_DrawItem_showMoveKnobs(){var _1=this.$636(this.moveKnobPoint),x=_1[0],y=_1[1];if(this.moveKnobOffset){x+=this.moveKnobOffset[0];y+=this.moveKnobOffset[1]}
this.$637=this.createAutoChild("moveKnob",{_constructor:"DrawKnob",x:x,y:y,drawPane:this.drawPane,autoDraw:true});this.observe(this.$637,"updatePoints","observer.moveBy(dX,dY)")}
,isc.A.hideMoveKnobs=function isc_DrawItem_hideMoveKnobs(){if(this.$637){this.$637.destroy();delete this.$637}}
,isc.A.getResizeKnobProperties=function isc_DrawItem_getResizeKnobProperties(_1){}
,isc.A.showResizeKnobs=function isc_DrawItem_showResizeKnobs(){var _1=this.resizeKnobPoints;for(var i=0;i<_1.length;i++){var _3=_1[i],_4=this.$636(_3),x=_4[0],y=_4[1];var _7=isc.addProperties({},this.getResizeKnobProperties(_3),{_constructor:"DrawKnob",targetShape:this,point:_3,x:x,y:y,drawPane:this.drawPane,autoDraw:true});var _8=this.createAutoChild("resizeKnob",_7);_8.addProperties({updatePoints:function(_9,_10,_11,_12){return this.targetShape.handleResizeKnobMove(this.point,_9,_10,_11,_12)}});if(!this.$638)this.$638=[];this.$638.add(_8)}}
,isc.A.handleResizeKnobMove=function isc_DrawItem_handleResizeKnobMove(_1,_2,_3,_4,_5){var _6=this.left,_7=this.top,_8=this.width,_9=this.height,_10;if(_1.contains("L")){_6=_2;_8-=_4;_10=true}else if(_1.contains("R")){_8+=_4}
if(_1.contains("T")){_7=_3;_9-=_5;_10=true}else if(_1.contains("B")){_9+=_5}
if(_8<1||_9<1)return false;this.resizeTo(_8,_9);if(_10)this.moveTo(_6,_7)}
,isc.A.hideResizeKnobs=function isc_DrawItem_hideResizeKnobs(){if(this.$638){this.$638.map("destroy");delete this.$638}}
,isc.A.updateControlKnobs=function isc_DrawItem_updateControlKnobs(){if(this.$637){var _1=this.$636(this.moveKnobPoint);if(this.moveKnobOffset){_1[0]+=this.moveKnobOffset[0];_1[1]+=this.moveKnobOffset[1]}
var _2=this.drawPane.drawing2screen(_1);this.$637.setCenterPoint(_2[0],_2[1])}
if(this.$638){for(var i=0;i<this.$638.length;i++){var _4=this.$638[i],_1=this.$636(_4.point);var _2=this.drawPane.drawing2screen(_1);_4.setCenterPoint(_2[0],_2[1])}}}
,isc.A.setDrawPane=function isc_DrawItem_setDrawPane(_1){if(_1==this.drawPane)return;if(_1==null){this.erase();this.drawPane=null;return}
_1.addDrawItem(this)}
,isc.A.$63r=function isc_DrawItem__drawLineStartArrow(){return false}
,isc.A.$63s=function isc_DrawItem__drawLineEndArrow(){return false}
,isc.A.erase=function isc_DrawItem_erase(_1){if(!this.$if){if(this.drawPane&&this.drawPane.cancelDeferredDraw(this))return;this.logWarn("DrawItem not yet drawn - exiting erase()");return}
if(!_1){if(this.drawGroup)this.drawGroup.drawItems.remove(this);else this.drawPane.drawItems.remove(this)}
if(this.drawingVML){if(isc.Page.isLoaded())this.$44u.outerHTML="";else this.$44t.removeChild(this.$44u);this.$44t=null;this.$44u=null;this.$44w=null;this.$44x=null}else if(this.drawingSVG){this.$44y.removeChild(this.$44z);this.$44m=null;this.$44y=null;this.$44z=null}else if(this.drawingBitmap&&!_1){this.drawPane.redrawBitmap()}
if(this.knobs){for(var i=0;i<this.knobs.length;i++){this.$635(this.knobs[i])}}
this.$if=false}
,isc.A.$44v=function isc_DrawItem__getElementVML(_1){return isc.SB.concat("<VML:",this.vmlElementName," ID='",_1,"' ",this.getAttributesVML(),"><VML:STROKE",((this.lineColor&&this.lineColor!="")?" COLOR='"+this.lineColor:" ON='false"),"' WEIGHT='",this.lineWidth*this.drawPane.zoomLevel,"px","' OPACITY='",this.lineOpacity,"' DASHSTYLE='",this.linePattern,"' JOINSTYLE='miter' MITERLIMIT='8.0","' ENDCAP='"+((this.lineCap=="butt")?"flat":this.lineCap),(this.startArrow&&!this.$63r()?"' STARTARROW='"+this.startArrow:""),(this.endArrow&&!this.$63s()?"' ENDARROW='"+this.endArrow:""),"'/><VML:FILL",((this.fillColor&&!isc.isAn.emptyString(this.fillColor))?" COLOR='"+this.fillColor:" ON='false"),"' OPACITY='",this.fillOpacity,"'/></VML:",this.vmlElementName,">")}
,isc.A.getAttributesVML=function isc_DrawItem_getAttributesVML(){return""}
,isc.A.$440=function isc_DrawItem__getElementSVG(_1){return"<"+this.svgElementName+" id='"+_1+"' "+this.getAttributesSVG()+" stroke-width='"+this.lineWidth+"px"+"' stroke='"+((this.lineColor&&this.lineColor!="")?this.lineColor:"none")+"' stroke-opacity='"+this.lineOpacity+"' stroke-dasharray='"+this.$441()+"' stroke-linecap='"+this.lineCap+(this.startArrow&&!this.$63r()?"' marker-start='url(#"+this.$442()+")":"")+(this.endArrow&&!this.$63s()?"' marker-end='url(#"+this.$443()+")":"")+"' fill='"+((this.fillColor&&this.fillColor!="")?this.fillColor:"none")+"' fill-opacity='"+this.fillOpacity+"'>"+(this.contents||"")+"</"+this.svgElementName+">"}
,isc.A.getAttributesSVG=function isc_DrawItem_getAttributesSVG(){return""}
,isc.A.drawBitmap=function isc_DrawItem_drawBitmap(_1){_1.save();try{if(this.lineColor&&this.lineColor!=""){_1.lineWidth=this.lineWidth;_1.lineCap=this.lineCap;_1.strokeStyle=this.lineColor;_1.globalAlpha=this.lineOpacity;_1.beginPath();this.drawBitmapPath(_1);_1.stroke()}
if(this.fillColor&&this.fillColor!=""){_1.fillStyle=this.fillColor;_1.globalAlpha=this.fillOpacity;_1.beginPath();this.drawBitmapPath(_1);_1.fill()}}catch(e){if(isc.Browser.isMoz)this.$am(e);else this.logWarn("exception during drawBitmap(): "+e)}
_1.restore()}
,isc.A.$442=function isc_DrawItem__getSVGStartArrowID(){if(this.$444){if(this.startArrow=="block")return this.$444;if(this.$44m.getElementById(this.startArrow)){this.$444=this.startArrow;this.$445=null}else{this.logWarn("SVG marker '"+this.startArrow+"' does not exist; ignoring")}}else{if(this.startArrow==="block"||!this.$44m.getElementById(this.startArrow)){this.$444="isc_DrawItem_"+this.drawItemID+"$446";this.$445=this.$447(this.$444,this.lineColor,this.lineOpacity,true)}else{this.$444=this.startArrow}}
this.startArrow="block";return this.$444}
,isc.A.$443=function isc_DrawItem__getSVGEndArrowID(){if(this.$448){if(this.endArrow=="block")return this.$448;if(this.$44m.getElementById(this.endArrow)){this.$448=this.endArrow;this.$449=null}else{this.logWarn("SVG marker '"+this.endArrow+"' does not exist; ignoring")}}else{if(this.endArrow=="block"||!this.$44m.getElementById(this.endArrow)){this.$448="isc_DrawItem_"+this.drawItemID+"$45a";this.$449=this.$447(this.$448,this.lineColor,this.lineOpacity,false)}else{this.$448=this.endArrow}}
this.endArrow="block";return this.$448}
,isc.A.$447=function isc_DrawItem__drawArrowMarkerSVG(_1,_2,_3,_4){var _5="<marker id='"+_1+"' viewBox='0 0 10 10' refY='5' refX='"+(_4?"10":"0")+"' orient='auto' markerUnits='strokeWidth' markerWidth='4' markerHeight='3'><path d='"+(_4?"M 10 0 L 0 5 L 10 10 z":"M 0 0 L 10 5 L 0 10 z")+"' fill='"+((_2&&_2!="")?_2:"none")+"' fill-opacity='"+_3+"' stroke-width='0px'/></marker>";var _6=this.$44m.createRange();_6.setStart(this.$44o,0);this.$44o.appendChild(_6.createContextualFragment(_5));return this.$44o.lastChild.firstChild}
,isc.A.show=function isc_DrawItem_show(){this.hidden=false;if(this.drawingVML){this.$44u.style.visibility="visible"}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"visibility","visible")}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
,isc.A.hide=function isc_DrawItem_hide(){this.hidden=true;if(this.drawingVML){this.$44u.style.visibility="hidden"}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"visibility","hidden")}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
,isc.A.setLineWidth=function isc_DrawItem_setLineWidth(_1){if(_1!=null)this.lineWidth=_1;if(this.drawingVML){this.$44l(this.lineWidth*this.drawPane.zoomLevel)}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"stroke-width",this.lineWidth+"px");this.$44z.setAttributeNS(null,"stroke-dasharray",this.$441())}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
,isc.A.$44l=function isc_DrawItem__setLineWidthVML(_1){this.$44w.weight=_1+"px"}
,isc.A.setLineColor=function isc_DrawItem_setLineColor(_1){this.lineColor=_1;if(this.drawingVML){if(this.lineColor&&this.lineColor!=""){this.$44w.on=true;this.$44w.color=this.lineColor}else{this.$44w.on=false}}else if(this.drawingSVG){var _1=(this.lineColor&&this.lineColor!="")?this.lineColor:"none"
this.$44z.setAttributeNS(null,"stroke",_1);if(this.$445){this.$445.setAttributeNS(null,"stroke",_1);this.$445.setAttributeNS(null,"fill",_1)}
if(this.$449){this.$449.setAttributeNS(null,"stroke",_1);this.$449.setAttributeNS(null,"fill",_1)}}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
,isc.A.setLineOpacity=function isc_DrawItem_setLineOpacity(_1){if(_1!=null)this.lineOpacity=_1;if(this.drawingVML){this.$44w.opacity=this.lineOpacity}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"stroke-opacity",this.lineOpacity);if(this.$445){this.$445.setAttributeNS(null,"stroke-opacity",this.lineOpacity);this.$445.setAttributeNS(null,"fill-opacity",this.lineOpacity)}
if(this.$449){this.$449.setAttributeNS(null,"stroke-opacity",this.lineOpacity);this.$449.setAttributeNS(null,"fill-opacity",this.lineOpacity)}}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
,isc.A.setLinePattern=function isc_DrawItem_setLinePattern(_1){this.linePattern=_1;if(this.drawingVML){this.$44w.dashstyle=this.linePattern}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"stroke-dasharray",this.$441())}else if(this.drawingBitmap){}}
,isc.A.$441=function isc_DrawItem__getSVGDashArray(){var _1=this.linePattern;if(!_1||_1=="solid"||_1=="")return"none";if(isc.isAn.Array(_1))return _1.join("px,")+"px";var _2=this.$44r[_1];var _3=this.$44s[_1];if(this.lineCap!="butt"){_2=Math.max(0.1,_2-1);_3++}
return(_2*this.lineWidth)+"px,"+(_3*this.lineWidth)+"px"}
,isc.A.setLineCap=function isc_DrawItem_setLineCap(_1){if(_1!=null)this.lineCap=_1;if(this.drawingVML){this.$44w.endcap=(this.lineCap=="butt")?"flat":this.lineCap}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"stroke-linecap",this.lineCap);this.$44z.setAttributeNS(null,"stroke-dasharray",this.$441())}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
,isc.A.setStartArrow=function isc_DrawItem_setStartArrow(_1){var _2=this.$63r();var _3;if(_1!==_3)this.startArrow=_1;else _1=this.startArrow;var _4=this.$63r();if(_2!=_4){this.setStartPoint()}
if(_4)_1=null;if(this.drawingVML){this.$44w.startarrow=(_1?_1:"none")}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"marker-start",(_1?"url(#"+this.$442()+")":"none"))}else if(this.drawingBitmap){}}
,isc.A.setEndArrow=function isc_DrawItem_setEndArrow(_1){var _2=this.$63s();var _3;if(_1!==_3)this.endArrow=_1;else _1=this.endArrow;var _4=this.$63s();if(_2!=_4){this.setEndPoint()}
if(_4)_1=null;if(this.drawingVML){this.$44w.endarrow=(_1?_1:"none")}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"marker-end",(_1?"url(#"+this.$443()+")":"none"))}else if(this.drawingBitmap){}}
,isc.A.setFillColor=function isc_DrawItem_setFillColor(_1){this.fillColor=_1;if(this.drawingVML){if(this.fillColor&&this.fillColor!=""){this.$44x.on=true;this.$44x.color=this.fillColor}else{this.$44x.on=false}}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"fill",(this.fillColor&&this.fillColor!="")?this.fillColor:"none")}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
,isc.A.setFillOpacity=function isc_DrawItem_setFillOpacity(_1){if(_1!=null)this.fillOpacity=_1;if(this.drawingVML){this.$44x.opacity=this.fillOpacity}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"fill-opacity",this.fillOpacity)}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
,isc.A.bmMoveTo=function isc_DrawItem_bmMoveTo(_1,_2,_3){var _3=_3||this.drawPane.getBitmapContext();try{_3.moveTo(_1,_2)}catch(e){this.logWarn("error on moveTo(): left: "+_1+", top: "+_2+(this.logIsInfoEnabled("drawing")?this.getStackTrace():""))}}
,isc.A.bmLineTo=function isc_DrawItem_bmLineTo(_1,_2,_3){var _3=_3||this.drawPane.getBitmapContext();try{_3.lineTo(_1,_2)}catch(e){this.logWarn("error on lineTo(): left: "+_1+", top: "+_2+(this.logIsInfoEnabled("drawing")?this.getStackTrace():""))}}
,isc.A.bmTranslate=function isc_DrawItem_bmTranslate(_1,_2,_3){var _3=_3||this.drawPane.getBitmapContext();try{_3.translate(_1,_2)}catch(e){this.logWarn("error on translate(): left: "+_1+", top: "+_2+(this.logIsInfoEnabled("drawing")?this.getStackTrace():""))}}
,isc.A.bmRotate=function isc_DrawItem_bmRotate(_1,_2){var _2=_2||this.drawPane.getBitmapContext();try{_2.rotate(_1)}catch(e){this.logWarn("error on translate(): angle: "+_1+(this.logIsInfoEnabled("drawing")?this.getStackTrace():""))}}
,isc.A.bmFillText=function isc_DrawItem_bmFillText(_1,_2,_3,_4){var _4=_4||this.drawPane.getBitmapContext();try{_4.fillText(_1,_2,_3)}catch(e){this.logWarn("error on fillText(): text: "+_1+", left: "+_2+", top: "+_3+(this.logIsInfoEnabled("drawing")?this.getStackTrace():""))}}
);isc.B._maxIndex=isc.C+46;isc.defineClass("DrawGroup","DrawItem");isc.A=isc.DrawGroup.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.left=0;isc.A.top=0;isc.B.push(isc.A.init=function isc_DrawGroup_init(){if(!this.drawItems)this.drawItems=[];this.Super("init")}
,isc.A.erase=function isc_DrawGroup_erase(_1){for(var i=0;i<this.drawItems.length;i++){this.drawItems[i].erase(true)}
this.drawItems=[];this.Super("erase",arguments)}
,isc.A.$44v=function isc_DrawGroup__getElementVML(_1){return isc.SB.concat("<VML:GROUP ID='",_1,"' STYLE='position:absolute;left:0;top:0;","width:100;height:100;' COORDSIZE='100 100' COORDORIGIN='",(-this.left)," ",(-this.top),"'></VML:GROUP>")}
,isc.A.$440=function isc_DrawGroup__getElementSVG(_1){return"<g id='"+_1+"' transform='translate("+this.left+","+this.top+")'></g>"}
,isc.A.drawBitmap=function isc_DrawGroup_drawBitmap(_1){_1.save();_1.translate(this.left,this.top);for(var i=0;i<this.drawItems.length;i++){if(!this.drawItems[i].hidden)this.drawItems[i].drawBitmap(_1)}
_1.restore()}
,isc.A.setLineWidth=function isc_DrawGroup_setLineWidth(_1){this.logWarn("no setLineWidth")}
,isc.A.$44l=function isc_DrawGroup__setLineWidthVML(_1){this.logWarn("no $44l")}
,isc.A.setLineColor=function isc_DrawGroup_setLineColor(_1){this.logWarn("no setLineColor")}
,isc.A.setLineOpacity=function isc_DrawGroup_setLineOpacity(_1){this.logWarn("no setLineOpacity")}
,isc.A.setLinePattern=function isc_DrawGroup_setLinePattern(_1){this.logWarn("no setLinePattern")}
,isc.A.setLineCap=function isc_DrawGroup_setLineCap(_1){this.logWarn("no setLineCap")}
,isc.A.setStartArrow=function isc_DrawGroup_setStartArrow(_1){this.logWarn("no setStartArrow")}
,isc.A.setEndArrow=function isc_DrawGroup_setEndArrow(_1){this.logWarn("no setEndArrow")}
,isc.A.setFillColor=function isc_DrawGroup_setFillColor(_1){this.logWarn("no setFillColor")}
,isc.A.setFillOpacity=function isc_DrawGroup_setFillOpacity(_1){this.logWarn("no setFillOpacity")}
,isc.A.setLeft=function isc_DrawGroup_setLeft(_1){if(_1!=null)this.left=_1;if(this.drawingVML){this.$44u.coordorigin.x=-this.left}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"transform","translate("+this.left+","+this.top+")")}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
,isc.A.setTop=function isc_DrawGroup_setTop(_1){if(_1!=null)this.top=_1;if(this.drawingVML){this.$44u.coordorigin.y=-this.top}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"transform","translate("+this.left+","+this.top+")")}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
,isc.A.moveTo=function isc_DrawGroup_moveTo(_1,_2){if(_1!=null)this.setLeft(_1);if(_2!=null)this.setTop(_2)}
,isc.A.moveBy=function isc_DrawGroup_moveBy(_1,_2){if(_1)this.setLeft(this.left+_1);if(_2)this.setTop(this.top+_2);this.moved(_1,_2)}
);isc.B._maxIndex=isc.C+19;isc.defineClass("DrawLine","DrawItem");isc.A=isc.DrawLine.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.startPoint=[0,0];isc.A.endPoint=[100,100];isc.A.svgElementName="line";isc.A.vmlElementName="LINE";isc.B.push(isc.A.init=function isc_DrawLine_init(){this.startLeft=this.startLeft||this.startPoint[0];this.startTop=this.startTop||this.startPoint[1];this.endLeft=this.endLeft||this.endPoint[0];this.endTop=this.endTop||this.endPoint[1];this.Super("init")}
,isc.A.$45b=function isc_DrawLine__getArrowAdjustedPoints(){if(this.startArrow||this.endArrow){return isc.GraphMath.trimLineEnds(this.startLeft,this.startTop,this.endLeft,this.endTop,this.startArrow?this.lineWidth*3:0,this.endArrow?this.lineWidth*3:0)}else{return[this.startLeft,this.startTop,this.endLeft,this.endTop]}}
,isc.A.setLineWidth=function isc_DrawLine_setLineWidth(_1){this.Super("setLineWidth",arguments);if(this.drawingSVG)this.setStartPoint()}
,isc.A.setStartArrow=function isc_DrawLine_setStartArrow(_1){this.Super("setStartArrow",arguments);if(this.drawingSVG)this.setStartPoint()}
,isc.A.setEndArrow=function isc_DrawLine_setEndArrow(_1){this.Super("setEndArrow",arguments);if(this.drawingSVG)this.setEndPoint()}
,isc.A.getAttributesVML=function isc_DrawLine_getAttributesVML(){return isc.SB.concat("FROM='",this.startLeft," ",this.startTop,"' TO='",this.endLeft," ",this.endTop,"'")}
,isc.A.getAttributesSVG=function isc_DrawLine_getAttributesSVG(){var _1=this.$45b();return"x1='"+_1[0]+"' y1='"+_1[1]+"' x2='"+_1[2]+"' y2='"+_1[3]+"'"}
,isc.A.drawBitmapPath=function isc_DrawLine_drawBitmapPath(_1){var _2=(parseInt(this.lineWidth)%2)==1?0.5:0,_3=parseFloat(this.startLeft)+_2,_4=parseFloat(this.startTop)+_2,_5=parseFloat(this.endLeft)+_2,_6=parseFloat(this.endTop)+_2;this.bmMoveTo(_3,_4,_1);this.bmLineTo(_5,_6,_1)}
,isc.A.setStartPoint=function isc_DrawLine_setStartPoint(_1,_2){if(_1!=null)this.startLeft=_1;if(_2!=null)this.startTop=_2;if(this.drawingVML){this.$44u.from=this.startLeft+" "+this.startTop}else if(this.drawingSVG){var _3=this.$45b();this.$44z.setAttributeNS(null,"x1",_3[0]);this.$44z.setAttributeNS(null,"y1",_3[1]);if(this.endArrow){this.$44z.setAttributeNS(null,"x2",_3[2]);this.$44z.setAttributeNS(null,"y2",_3[3])}}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}
this.updateControlKnobs()}
,isc.A.setEndPoint=function isc_DrawLine_setEndPoint(_1,_2){if(_1!=null)this.endLeft=_1;if(_2!=null)this.endTop=_2;if(this.drawingVML){this.$44u.to=this.endLeft+" "+this.endTop}else if(this.drawingSVG){var _3=this.$45b();this.$44z.setAttributeNS(null,"x2",_3[2]);this.$44z.setAttributeNS(null,"y2",_3[3]);if(this.startArrow){this.$44z.setAttributeNS(null,"x1",_3[0]);this.$44z.setAttributeNS(null,"y1",_3[1])}}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}
this.updateControlKnobs()}
,isc.A.showStartPointKnobs=function isc_DrawLine_showStartPointKnobs(){this.$639=this.createAutoChild("startKnob",{_constructor:"DrawKnob",x:this.startLeft,y:this.startTop,drawPane:this.drawPane,autoDraw:true});this.observe(this.$639,"updatePoints","observer.setStartPoint(x,y)")}
,isc.A.hideStartPointKnobs=function isc_DrawLine_hideStartPointKnobs(){if(this.$639){this.$639.destroy();delete this.$639}}
,isc.A.showEndPointKnobs=function isc_DrawLine_showEndPointKnobs(){this.$64a=this.createAutoChild("endKnob",{_constructor:"DrawKnob",x:this.endLeft,y:this.endTop,drawPane:this.drawPane,autoDraw:true});this.observe(this.$64a,"updatePoints","observer.setEndPoint(x,y)")}
,isc.A.hideEndPointKnobs=function isc_DrawLine_hideEndPointKnobs(){if(this.$64a){this.$64a.destroy();delete this.$64a}}
,isc.A.moveBy=function isc_DrawLine_moveBy(_1,_2){this.startLeft+=_1;this.startTop+=_2;this.endLeft+=_1;this.endTop+=_2;if(this.drawingVML){this.$44u.from=this.startLeft+" "+this.startTop;this.$44u.to=this.endLeft+" "+this.endTop}else if(this.drawingSVG){var _3=this.$45b();this.$44z.setAttributeNS(null,"x1",_3[0]);this.$44z.setAttributeNS(null,"y1",_3[1]);this.$44z.setAttributeNS(null,"x2",_3[2]);this.$44z.setAttributeNS(null,"y2",_3[3])}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
,isc.A.moveTo=function isc_DrawLine_moveTo(_1,_2){var x,y;if(_1!=null)x=_1-this.startLeft;if(_2!=null)y=_2-this.startTop;this.moveBy(x,y)}
,isc.A.updateControlKnobs=function isc_DrawLine_updateControlKnobs(){this.Super("updateControlKnobs",arguments);if(this.$639){var _1=this.startLeft,_2=this.startTop,_3=this.drawPane.drawing2screen([_1,_2,0,0]);this.$639.setCenterPoint(_3[0],_3[1])}
if(this.$64a){var _1=this.endLeft,_2=this.endTop,_3=this.drawPane.drawing2screen([_1,_2,0,0]);this.$64a.setCenterPoint(_3[0],_3[1])}}
);isc.B._maxIndex=isc.C+17;isc.defineClass("DrawRect","DrawItem");isc.A=isc.DrawRect.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.left=0;isc.A.top=0;isc.A.width=100;isc.A.height=100;isc.A.rounding=0;isc.A.svgElementName="rect";isc.A.vmlElementName="ROUNDRECT";isc.B.push(isc.A.getAttributesVML=function isc_DrawRect_getAttributesVML(){return isc.SB.concat("STYLE='position:absolute; left:",this.left,"px; top:",this.top,"px; width:",this.width,"px; height:",this.height,"px;'"," ARCSIZE='"+this.rounding/ 2+"'")}
,isc.A.getAttributesSVG=function isc_DrawRect_getAttributesSVG(){return"x='"+this.left+"' y='"+this.top+"' width='"+this.width+"' height='"+this.height+"'"+(this.rounding?" rx='"+(this.rounding*Math.min(this.width,this.height)/2)+"'":"")}
,isc.A.drawBitmapPath=function isc_DrawRect_drawBitmapPath(_1){if(this.rounding==0){this.bmMoveTo(this.left,this.top);this.bmLineTo(this.left+this.width,this.top);this.bmLineTo(this.left+this.width,this.top+this.height);this.bmLineTo(this.left,this.top+this.height);this.bmLineTo(this.left,this.top)}else{var _2=this.rounding*(Math.min(this.width,this.height)/2);this.bmMoveTo(this.left+_2,this.top);this.bmLineTo(this.left+this.width-_2,this.top);_1.arc(this.left+this.width-_2,this.top+_2,_2,Math.PI*1.5,Math.PI*2,false);this.bmLineTo(this.left+this.width,this.top+this.height-_2);_1.arc(this.left+this.width-_2,this.top+this.height-_2,_2,0,Math.PI/ 2,false);this.bmLineTo(this.left+_2,this.top+this.height);_1.arc(this.left+_2,this.top+this.height-_2,_2,Math.PI/ 2,Math.PI,false);this.bmLineTo(this.left,this.top+_2);_1.arc(this.left+_2,this.top+_2,_2,Math.PI,Math.PI*1.5,false)}}
,isc.A.setCenter=function isc_DrawRect_setCenter(_1,_2){if(_1!=null)_1=_1-Math.round(this.width/ 2);if(_2!=null)_2=_2-Math.round(this.height/ 2);this.moveTo(_1,_2)}
,isc.A.moveBy=function isc_DrawRect_moveBy(_1,_2){this.left+=_1;this.top+=_2;if(this.drawingVML){this.$44u.style.left=this.left;this.$44u.style.top=this.top}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"x",this.left);this.$44z.setAttributeNS(null,"y",this.top)}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}
this.moved(_1,_2)}
,isc.A.moveTo=function isc_DrawRect_moveTo(_1,_2){this.moveBy(_1-this.left,_2-this.top)}
,isc.A.setLeft=function isc_DrawRect_setLeft(_1){this.moveTo(_1)}
,isc.A.setTop=function isc_DrawRect_setTop(_1){this.moveTo(null,_1)}
,isc.A.resizeTo=function isc_DrawRect_resizeTo(_1,_2){var _3=0,_4=0;if(_1!=null)_3=_1-this.width;if(_2!=null)_4=_2-this.height;this.resizeBy(_3,_4)}
,isc.A.resizeBy=function isc_DrawRect_resizeBy(_1,_2){if(_1!=null)this.width+=_1;if(_2!=null)this.height+=_2;if(this.drawingVML){this.$44u.style.width=this.width;this.$44u.style.height=this.height}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"width",this.width);this.$44z.setAttributeNS(null,"height",this.height)}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}
this.resized(_1,_2)}
,isc.A.setWidth=function isc_DrawRect_setWidth(_1){this.resizeTo(_1)}
,isc.A.setHeight=function isc_DrawRect_setHeight(_1){this.resizeTo(null,_1)}
,isc.A.setRect=function isc_DrawRect_setRect(_1,_2,_3,_4){this.moveTo(_1,_2);this.resizeTo(_3,_4)}
,isc.A.setRounding=function isc_DrawRect_setRounding(_1){this.rounding=_1;if(this.drawingVML){this.erase();this.draw()}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"rx",(this.rounding?(this.rounding*Math.min(this.width,this.height)/2):null))}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
);isc.B._maxIndex=isc.C+14;isc.defineClass("DrawOval","DrawItem");isc.A=isc.DrawOval.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.left=0;isc.A.top=0;isc.A.width=100;isc.A.height=100;isc.A.svgElementName="ellipse";isc.A.vmlElementName="OVAL";isc.B.push(isc.A.init=function isc_DrawOval_init(){if(!this.centerPoint)this.$63t();else this.$63u();this.Super("init")}
,isc.A.$63u=function isc_DrawOval__deriveRectFromCenterPoint(){this.rx=this.rx||this.radius;this.ry=this.ry||this.radius;this.width=this.rx*2;this.height=this.ry*2;this.left=this.centerPoint[0]-this.width/ 2;this.top=this.centerPoint[1]-this.height/ 2}
,isc.A.$63t=function isc_DrawOval__deriveCenterPointFromRect(){this.centerPoint=[];this.centerPoint[0]=this.left+this.width/ 2;this.centerPoint[1]=this.top+this.height/ 2;this.rx=this.width/ 2;this.ry=this.height/ 2}
,isc.A.getAttributesVML=function isc_DrawOval_getAttributesVML(){return isc.SB.concat("STYLE='position:absolute;left:",this.left,"px;top:",this.top,"px;width:",this.width,"px;height:",this.height,"px;'")}
,isc.A.getAttributesSVG=function isc_DrawOval_getAttributesSVG(){return"cx='"+this.centerPoint[0]+"' cy='"+this.centerPoint[1]+"' rx='"+this.rx+"' ry='"+this.ry+"'"}
,isc.A.drawBitmapPath=function isc_DrawOval_drawBitmapPath(_1){_1.moveTo(this.centerPoint[0]+this.rx,this.centerPoint[1]);_1.arc(this.centerPoint[0],this.centerPoint[1],this.rx,0,Math.PI*2,true)}
,isc.A.setCenterPoint=function isc_DrawOval_setCenterPoint(_1,_2){if(isc.isAn.Array(_1)){_2=_1[1];_1=_1[0]}
var _3=0,_4=0;if(_1!=null)_3=_1-this.centerPoint[0];if(_2!=null)_4=_2-this.centerPoint[1];this.moveBy(_3,_4)}
,isc.A.moveBy=function isc_DrawOval_moveBy(_1,_2){if(_1!=null)this.centerPoint[0]+=_1
if(_2!=null)this.centerPoint[1]+=_2;this.$63u();if(!this.$if)return;if(this.drawingVML){this.$44u.style.left=this.centerPoint[0]-this.rx;this.$44u.style.top=this.centerPoint[1]-this.ry}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"cx",this.centerPoint[0]);this.$44z.setAttributeNS(null,"cy",this.centerPoint[1])}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}
this.moved(_1,_2)}
,isc.A.moveTo=function isc_DrawOval_moveTo(_1,_2){var _3,_4;if(_1!=null)_3=_1-this.left;if(_2!=null)_4=_2-this.top;this.moveBy(_3,_4)}
,isc.A.setLeft=function isc_DrawOval_setLeft(_1){this.moveTo(_1)}
,isc.A.setTop=function isc_DrawOval_setTop(_1){this.moveTo(null,_1)}
,isc.A.resizeBy=function isc_DrawOval_resizeBy(_1,_2,_3){if(_1!=null)this.width+=_1;if(_2!=null)this.height+=_2;if(_3){if(_1!=null)this.left+=Math.round(_1/ 2);if(_2!=null)this.top+=Math.round(_2/ 2)}
this.$63t();if(this.drawingVML){this.$44u.style.width=this.width;this.$44u.style.height=this.height;if(_3){this.$44u.style.left=this.left;this.$44u.style.top=this.top}}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"rx",this.rx);this.$44z.setAttributeNS(null,"ry",this.ry);if(!_3){this.$44z.setAttributeNS(null,"cx",this.centerPoint[0]);this.$44z.setAttributeNS(null,"cy",this.centerPoint[1])}}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}
this.resized(_1,_2);if(_3)this.moved(_1/ 2,_2/ 2)}
,isc.A.resizeTo=function isc_DrawOval_resizeTo(_1,_2,_3){var _4=0,_5=0;if(_1!=null)_4=_1-this.width;if(_2!=null)_5=_2-this.height;this.resizeBy(_4,_5,_3)}
,isc.A.setWidth=function isc_DrawOval_setWidth(_1){this.resizeTo(_1)}
,isc.A.setHeight=function isc_DrawOval_setHeight(_1){this.resizeTo(null,_1)}
,isc.A.setRect=function isc_DrawOval_setRect(_1,_2,_3,_4){this.moveTo(_1,_2);this.resizeTo(_3,_4)}
,isc.A.setRadii=function isc_DrawOval_setRadii(_1,_2){if(isc.isAn.Array(_1)){_2=_1[1];_1=_1[0]}
var _3,_4;if(_1!=null)_3=2*_1;if(_2!=null)_4=2*_2;this.resizeTo(_3,_4,true)}
,isc.A.setRadius=function isc_DrawOval_setRadius(_1){this.setRadii(_1,_1)}
,isc.A.setOval=function isc_DrawOval_setOval(_1,_2,_3,_4){this.setCenterPoint(_1,_2);this.setRadii(_3,_4)}
);isc.B._maxIndex=isc.C+19;isc.defineClass("DrawLabel","DrawItem");isc.A=isc.DrawLabel.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.left=0;isc.A.top=0;isc.A.fontFamily="Tahoma";isc.A.fontSize=18;isc.A.fontWeight="bold";isc.A.fontStyle="normal";isc.A.styleName="drawLabelText";isc.B.push(isc.A.init=function isc_DrawLabel_init(){this.$44k=this.fontSize;this.Super("init")}
,isc.A.$44v=function isc_DrawLabel__getElementVML(_1){if(this.synchTextMove){return isc.SB.concat("<VML:RECT ID='",_1,"' STYLE='position:absolute;left:",this.left,"; top:",this.top,";'><VML:TEXTBOX INSET='0px, 0px, 0px, 0px' STYLE='overflow:visible","; font-family:",this.fontFamily,"; font-size:",this.fontSize*this.drawPane.zoomLevel,"; font-weight:",this.fontWeight,"; font-style:",this.fontStyle,";'><NOBR>",this.contents,"</NOBR></VML:TEXTBOX></VML:RECT>")}else{var _2=this.drawPane.drawing2screen([this.left,this.top,0,0]);return isc.SB.concat("<DIV ID='",_1,"' STYLE='position:absolute; overflow:visible; width:1; height:1","; left:",_2[0],"; top:",_2[1],(this.rotation?";writing-mode: tb-rl":""),"; font-family:",this.fontFamily,"; font-size:",this.fontSize*this.drawPane.zoomLevel,"; font-weight:",this.fontWeight,"; font-style:",this.fontStyle,";color:",this.lineColor,";'><NOBR>",this.contents,"</NOBR></DIV>")}}
,isc.A.$440=function isc_DrawLabel__getElementSVG(_1){return"<text id='"+_1+"' x='"+this.left+"' y='"+this.top+"' dominant-baseline='text-before-edge"+"' font-family='"+this.fontFamily+"' font-size='"+this.fontSize+"' font-weight='"+this.fontWeight+"' font-style='"+this.fontStyle+"'>"+this.contents+"</text>"}
,isc.A.makeHTMLText=function isc_DrawLabel_makeHTMLText(){var _1=this.$45c=isc.HTMLFlow.create({left:this.left,top:this.top,rotation:this.rotation,transformOrigin:"0 0",width:1,height:1,contents:isc.SB.concat("<span style='font-family:",this.fontFamily,";font-weight:",this.fontWeight,";font-size:",Math.round(this.fontSize*this.drawPane.zoomLevel),";font-style:",this.fontStyle,";color:",this.lineColor,";white-space:nowrap'>",this.contents,"</span>"),autoDraw:false});this.drawPane.addChild(_1)}
,isc.A.drawBitmap=function isc_DrawLabel_drawBitmap(_1){if(this.useHTML||isc.Browser.isIPhone){if(!this.$45c)this.makeHTMLText()}else{this.Super("drawBitmap",arguments)}}
,isc.A.erase=function isc_DrawLabel_erase(){if(this.$45c)this.$45c.destroy();this.Super("erase",arguments)}
,isc.A.destroy=function isc_DrawLabel_destroy(){if(this.$45c)this.$45c.destroy();this.Super("destroy",arguments)}
,isc.A.drawBitmapPath=function isc_DrawLabel_drawBitmapPath(_1){_1.fillStyle=this.lineColor;_1.textBaseline="top";var _2=(this.fontStyle!="normal"?this.fontStyle+" ":"")+(this.fontWeight!="normal"?this.fontWeight+" ":"")+this.fontSize+"px "+this.fontFamily;_1.font=_2;this.bmTranslate(this.left,this.top,_1);if(this.rotation){this.bmRotate((this.rotation/ 180)*Math.PI,_1)}
this.bmFillText(this.contents,0,0,_1)}
,isc.A.getTextWidth=function isc_DrawLabel_getTextWidth(){if(this.drawingVML){if(this.synchTextMove){return this.$44u.firstChild.scrollWidth}else{return this.$44u.scrollWidth}}else if(this.drawingSVG){return this.$44z.getComputedTextLength()}}
,isc.A.getTextHeight=function isc_DrawLabel_getTextHeight(){if(this.drawingVML){if(this.synchTextMove){return this.$44u.firstChild.scrollHeight}else{return this.$44u.scrollWidth}}else if(this.drawingSVG){return this.$44z.getBBox().height}}
,isc.A.setFontSize=function isc_DrawLabel_setFontSize(_1){if(_1!=null)this.fontSize=_1;if(this.drawingVML){this.$44j.fontSize=this.fontSize*this.drawPane.zoomLevel}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"font-size",this.fontSize)}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
,isc.A.setLineWidth=function isc_DrawLabel_setLineWidth(_1){this.logWarn("no setLineWidth")}
,isc.A.$44l=function isc_DrawLabel__setLineWidthVML(_1){this.logWarn("no $44l")}
,isc.A.setLineColor=function isc_DrawLabel_setLineColor(_1){this.logWarn("no setLineColor")}
,isc.A.setLineOpacity=function isc_DrawLabel_setLineOpacity(_1){this.logWarn("no setLineOpacity")}
,isc.A.setLinePattern=function isc_DrawLabel_setLinePattern(_1){this.logWarn("no setLinePattern")}
,isc.A.setLineCap=function isc_DrawLabel_setLineCap(_1){this.logWarn("no setLineCap")}
,isc.A.setStartArrow=function isc_DrawLabel_setStartArrow(_1){this.logWarn("no setStartArrow")}
,isc.A.setEndArrow=function isc_DrawLabel_setEndArrow(_1){this.logWarn("no setEndArrow")}
,isc.A.setFillColor=function isc_DrawLabel_setFillColor(_1){this.logWarn("no setFillColor")}
,isc.A.setFillOpacity=function isc_DrawLabel_setFillOpacity(_1){this.logWarn("no setFillOpacity")}
);isc.B._maxIndex=isc.C+21;isc.defineClass("DrawImage","DrawItem");isc.A=isc.DrawImage.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.left=0;isc.A.top=0;isc.A.width=16;isc.A.height=16;isc.A.src="blank.png";isc.B.push(isc.A.init=function isc_DrawImage_init(){this.Super("init")}
,isc.A.$44v=function isc_DrawImage__getElementVML(_1){return isc.SB.concat("<VML:IMAGE ID='",_1,"' SRC='",this.src,(this.title?"' ALT='"+this.title:""),"' STYLE='left:",this.left,"; top:",this.top,"; width:",this.width,"; height:",this.height,";'></VML:IMAGE>")}
,isc.A.$440=function isc_DrawImage__getElementSVG(_1){return"<image id='"+_1+"' x='"+this.left+"' y='"+this.top+"' width='"+this.width+"px' height='"+this.height+"px' xlink:href='"+isc.Page.getAppDir()+this.src+"'>"+(this.title?"<title>"+this.title+"</title>":"")+"</image>"}
,isc.A.drawBitmap=function isc_DrawImage_drawBitmap(_1){}
,isc.A.setSrc=function isc_DrawImage_setSrc(_1){if(_1!=null)this.src=_1;if(this.drawingVML){this.$44u.src=this.src}else if(this.drawingSVG){this.$44z.setAttributeNS("http://www.w3.org/1999/xlink","href",this.src)}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
,isc.A.setLineWidth=function isc_DrawImage_setLineWidth(_1){this.logWarn("no setLineWidth")}
,isc.A.$44l=function isc_DrawImage__setLineWidthVML(_1){this.logWarn("no $44l")}
,isc.A.setLineColor=function isc_DrawImage_setLineColor(_1){this.logWarn("no setLineColor")}
,isc.A.setLineOpacity=function isc_DrawImage_setLineOpacity(_1){this.logWarn("no setLineOpacity")}
,isc.A.setLinePattern=function isc_DrawImage_setLinePattern(_1){this.logWarn("no setLinePattern")}
,isc.A.setLineCap=function isc_DrawImage_setLineCap(_1){this.logWarn("no setLineCap")}
,isc.A.setStartArrow=function isc_DrawImage_setStartArrow(_1){this.logWarn("no setStartArrow")}
,isc.A.setEndArrow=function isc_DrawImage_setEndArrow(_1){this.logWarn("no setEndArrow")}
,isc.A.setFillColor=function isc_DrawImage_setFillColor(_1){this.logWarn("no setFillColor")}
,isc.A.setFillOpacity=function isc_DrawImage_setFillOpacity(_1){this.logWarn("no setFillOpacity")}
);isc.B._maxIndex=isc.C+15;isc.defineClass("DrawCurve","DrawItem");isc.A=isc.DrawCurve.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.startPoint=[0,0];isc.A.endPoint=[100,100];isc.A.controlPoint1=[100,0];isc.A.controlPoint2=[0,100];isc.A.svgElementName="path";isc.A.vmlElementName="curve";isc.B.push(isc.A.init=function isc_DrawCurve_init(){this.Super("init")}
,isc.A.getAttributesVML=function isc_DrawCurve_getAttributesVML(){return isc.SB.concat("FROM='",this.startPoint[0]," ",this.startPoint[1],"' TO='",this.endPoint[0]," ",this.endPoint[1],"' CONTROL1='",this.controlPoint1[0]," ",this.controlPoint1[1],"' CONTROL2='",this.controlPoint2[0]," ",this.controlPoint2[1],"'")}
,isc.A.getAttributesSVG=function isc_DrawCurve_getAttributesSVG(){return"d='"+this.getPathSVG()+"'"}
,isc.A.getPathSVG=function isc_DrawCurve_getPathSVG(){return"M"+this.startPoint[0]+" "+this.startPoint[1]+"C"+this.controlPoint1[0]+" "+this.controlPoint1[1]+" "+this.controlPoint2[0]+" "+this.controlPoint2[1]+" "+this.endPoint[0]+" "+this.endPoint[1]}
,isc.A.drawBitmapPath=function isc_DrawCurve_drawBitmapPath(_1){_1.moveTo(this.startPoint[0],this.startPoint[1]);_1.bezierCurveTo(this.controlPoint1[0],this.controlPoint1[1],this.controlPoint2[0],this.controlPoint2[1],this.endPoint[0],this.endPoint[1])}
,isc.A.setStartPoint=function isc_DrawCurve_setStartPoint(_1,_2){if(_1!=null)this.startPoint[0]=_1;if(_2!=null)this.startPoint[1]=_2;if(this.drawingVML){this.$44u.from=this.startPoint[0]+" "+this.startPoint[1]}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"d",this.getPathSVG())}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}
this.updateControlKnobs()}
,isc.A.setEndPoint=function isc_DrawCurve_setEndPoint(_1,_2){if(_1!=null)this.endPoint[0]=_1;if(_2!=null)this.endPoint[1]=_2;if(this.drawingVML){this.$44u.to=this.endPoint[0]+" "+this.endPoint[1]}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"d",this.getPathSVG())}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}
this.updateControlKnobs()}
,isc.A.setControlPoint1=function isc_DrawCurve_setControlPoint1(_1,_2){if(_1!=null)this.controlPoint1[0]=_1;if(_2!=null)this.controlPoint1[1]=_2;if(this.drawingVML){this.$44u.control1=this.controlPoint1[0]+" "+this.controlPoint1[1]}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"d",this.getPathSVG())}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}
this.updateControlKnobs()}
,isc.A.setControlPoint2=function isc_DrawCurve_setControlPoint2(_1,_2){if(_1!=null)this.controlPoint2[0]=_1;if(_2!=null)this.controlPoint2[1]=_2;if(this.drawingVML){this.$44u.control2=this.controlPoint2[0]+" "+this.controlPoint2[1]}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"d",this.getPathSVG())}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}
this.updateControlKnobs()}
,isc.A.showStartPointKnobs=function isc_DrawCurve_showStartPointKnobs(){this.$639=this.createAutoChild("startKnob",{_constructor:"DrawKnob",x:this.startPoint[0],y:this.startPoint[1],drawPane:this.drawPane,autoDraw:true});this.observe(this.$639,"updatePoints","observer.setStartPoint(x,y)")}
,isc.A.hideStartPointKnobs=function isc_DrawCurve_hideStartPointKnobs(){if(this.$639){this.$639.destroy();delete this.$639}}
,isc.A.showEndPointKnobs=function isc_DrawCurve_showEndPointKnobs(){this.$64a=this.createAutoChild("endKnob",{_constructor:"DrawKnob",x:this.endPoint[0],y:this.endPoint[1],drawPane:this.drawPane,autoDraw:true});this.observe(this.$64a,"updatePoints","observer.setEndPoint(x,y)")}
,isc.A.hideEndPointKnobs=function isc_DrawCurve_hideEndPointKnobs(){if(this.$64a){this.$64a.destroy();delete this.$64a}}
,isc.A.showControlPoint1Knobs=function isc_DrawCurve_showControlPoint1Knobs(){this.$64b=this.createAutoChild("c1Knob",{_constructor:"DrawKnob",x:this.controlPoint1[0],y:this.controlPoint1[1],drawPane:this.drawPane,autoDraw:true});this.$64c=this.createAutoChild("c1Line",{_constructor:"DrawLine",startLeft:this.startPoint[0],startTop:this.startPoint[1],endLeft:this.controlPoint1[0],endTop:this.controlPoint1[1],drawPane:this.drawPane,autoDraw:true});this.observe(this.$64b,"updatePoints","observer.setControlPoint1(x,y)")}
,isc.A.hideControlPoint1Knobs=function isc_DrawCurve_hideControlPoint1Knobs(){if(this.$64b){this.$64b.destroy();delete this.$64b}
if(this.$64c){this.$64c.erase();delete this.$64c}}
,isc.A.showControlPoint2Knobs=function isc_DrawCurve_showControlPoint2Knobs(){this.$64d=this.createAutoChild("c2Knob",{_constructor:"DrawKnob",x:this.controlPoint2[0],y:this.controlPoint2[1],drawPane:this.drawPane,autoDraw:true});this.$64e=this.createAutoChild("c2Line",{_constructor:"DrawLine",startLeft:this.endPoint[0],startTop:this.endPoint[1],endLeft:this.controlPoint2[0],endTop:this.controlPoint2[1],drawPane:this.drawPane,autoDraw:true});this.observe(this.$64d,"updatePoints","observer.setControlPoint2(x,y)")}
,isc.A.hideControlPoint2Knobs=function isc_DrawCurve_hideControlPoint2Knobs(){if(this.$64d){this.$64d.destroy();delete this.$64d}
if(this.$64e){this.$64e.erase();delete this.$64e}}
,isc.A.updateControlKnobs=function isc_DrawCurve_updateControlKnobs(){this.Super("updateControlKnobs",arguments);if(this.$639||this.$64c){var _1=this.startPoint[0],_2=this.startPoint[1];if(this.$64c)this.$64c.setStartPoint(_1,_2);if(this.$639){var _3=this.drawPane.drawing2screen([_1,_2,0,0]);this.$639.setCenterPoint(_3[0],_3[1])}}
if(this.$64a||this.$64e){var _1=this.endPoint[0],_2=this.endPoint[1];if(this.$64e)this.$64e.setStartPoint(_1,_2);if(this.$64a){var _3=this.drawPane.drawing2screen([_1,_2,0,0]);this.$64a.setCenterPoint(_3[0],_3[1])}}
if(this.$64b){var _1=this.controlPoint1[0],_2=this.controlPoint1[1];this.$64c.setEndPoint(_1,_2);var _3=this.drawPane.drawing2screen([_1,_2,0,0]);this.$64b.setCenterPoint(_3[0],_3[1])}
if(this.$64d){var _1=this.controlPoint2[0],_2=this.controlPoint2[1];this.$64e.setEndPoint(_1,_2);var _3=this.drawPane.drawing2screen([_1,_2,0,0]);this.$64d.setCenterPoint(_3[0],_3[1])}}
);isc.B._maxIndex=isc.C+18;isc.defineClass("DrawBlockConnector","DrawItem");isc.A=isc.DrawBlockConnector.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.startPoint=[0,0];isc.A.endPoint=[100,100];isc.A.bendSize=20;isc.A.svgElementName="path";isc.A.vmlElementName="TODO";isc.B.push(isc.A.init=function isc_DrawBlockConnector_init(){this.Super("init")}
,isc.A.getAttributesVML=function isc_DrawBlockConnector_getAttributesVML(){return"FROM='"+this.startPoint[0]+" "+this.startPoint[1]+"' TO='"+this.endPoint[0]+" "+this.endPoint[1]+"' CONTROL1='"+this.controlPoint1[0]+" "+this.controlPoint1[1]+"' CONTROL2='"+this.controlPoint2[0]+" "+this.controlPoint2[1]+"'"}
,isc.A.getAttributesSVG=function isc_DrawBlockConnector_getAttributesSVG(){return"d='"+this.getPathSVG()+"'"}
,isc.A.getPathSVG=function isc_DrawBlockConnector_getPathSVG(){return"M"+this.startPoint[0]+" "+this.startPoint[1]+"C"+this.controlPoint1[0]+" "+this.controlPoint1[1]+" "+this.controlPoint2[0]+" "+this.controlPoint2[1]+" "+this.endPoint[0]+" "+this.endPoint[1]}
,isc.A.drawBitmapPath=function isc_DrawBlockConnector_drawBitmapPath(_1){_1.moveTo(this.startPoint[0],this.startPoint[1]);_1.bezierCurveTo(this.controlPoint1[0],this.controlPoint1[1],this.controlPoint2[0],this.controlPoint2[1],this.endPoint[0],this.endPoint[1])}
,isc.A.setStartPoint=function isc_DrawBlockConnector_setStartPoint(_1,_2){if(_1!=null)this.startPoint[0]=_1;if(_2!=null)this.startPoint[1]=_2;if(this.drawingVML){this.$44u.from=this.startPoint[0]+" "+this.startPoint[1]}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"d",this.getPathSVG())}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
);isc.B._maxIndex=isc.C+6;isc.defineClass("DrawPath","DrawItem");isc.A=isc.DrawPath.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.points=[[0,0],[100,100]];isc.A.svgElementName="polyline";isc.A.vmlElementName="POLYLINE";isc.B.push(isc.A.getPointsText=function isc_DrawPath_getPointsText(){var _1=isc.SB.create(),_2=this.points;for(var i=0;i<_2.length;i++){_1.append(_2[i][0]," ",_2[i][1]);if(i<_2.length-1)_1.append(" ")}
return _1.toString()}
,isc.A.getAttributesVML=function isc_DrawPath_getAttributesVML(){return"POINTS='"+this.getPointsText()+"'"}
,isc.A.getAttributesSVG=function isc_DrawPath_getAttributesSVG(){return"points='"+this.getPointsText()+"'"}
,isc.A.drawBitmapPath=function isc_DrawPath_drawBitmapPath(_1){var _2=this.points;this.bmMoveTo(_2[0][0],_2[0][1],_1);for(var i=1;i<this.points.length;i++){var _4=_2[i];this.bmLineTo(_4[0],_4[1],_1)}}
,isc.A.setPoints=function isc_DrawPath_setPoints(_1){this.points=_1;if(this.drawingVML){this.$44u.points.value=this.getPointsText()}else if(this.drawingSVG){this.$44z.setAttributeNS(null,"points",this.getPointsText())}else if(this.drawingBitmap){this.drawPane.redrawBitmap()}}
);isc.B._maxIndex=isc.C+5;isc.defineClass("DrawLinePath","DrawPath");isc.A=isc.DrawLinePath.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.startPoint=[0,0];isc.A.endPoint=[100,100];isc.A.tailSize=30;isc.A.startArrow=null;isc.A.endArrow="open";isc.A.showStartPointKnobs=isc.DrawLine.getPrototype().showStartPointKnobs;isc.A.hideStartPointKnobs=isc.DrawLine.getPrototype().hideStartPointKnobs;isc.A.showEndPointKnobs=isc.DrawLine.getPrototype().showEndPointKnobs;isc.A.hideEndPointKnobs=isc.DrawLine.getPrototype().hideEndPointKnobs;isc.A.updateControlKnobs=isc.DrawLine.getPrototype().updateControlKnobs;isc.B.push(isc.A.init=function isc_DrawLinePath_init(){this.startLeft=this.startLeft||this.startPoint[0];this.startTop=this.startTop||this.startPoint[1];this.endLeft=this.endLeft||this.endPoint[0];this.endTop=this.endTop||this.endPoint[1];this.points=this.$45e();this.Super("init")}
,isc.A.$45e=function isc_DrawLinePath__getSegmentPoints(){var _1=this.tailSize;if(this.startLeft<=this.endLeft){_1=-_1}
var _2=10;if(this.startLeft>this.endLeft)_2=-_2;this.$45f=[];if(this.startArrow=="open"){this.$45f.addList([[this.startLeft+_2,this.startTop-_2],[this.startLeft,this.startTop],[this.startLeft+_2,this.startTop+_2]])}
this.$45f.addList([[this.startLeft,this.startTop],[this.startLeft-_1,this.startTop],[this.endLeft+_1,this.endTop],[this.endLeft,this.endTop]]);if(this.endArrow=="open"){this.$45f.addList([[this.endLeft-_2,this.endTop+_2],[this.endLeft,this.endTop],[this.endLeft-_2,this.endTop-_2]])}
return this.$45f}
,isc.A.$63r=function isc_DrawLinePath__drawLineStartArrow(){return this.startArrow=="open"}
,isc.A.$63s=function isc_DrawLinePath__drawLineEndArrow(){return this.endArrow=="open"}
,isc.A.setStartPoint=function isc_DrawLinePath_setStartPoint(_1,_2){if(_1!=null)this.startLeft=_1;if(_2!=null)this.startTop=_2;this.setPoints(this.$45e());this.updateControlKnobs()}
,isc.A.setEndPoint=function isc_DrawLinePath_setEndPoint(_1,_2){if(_1!=null)this.endLeft=_1;if(_2!=null)this.endTop=_2;this.setPoints(this.$45e());this.updateControlKnobs()}
,isc.A.moveBy=function isc_DrawLinePath_moveBy(_1,_2){this.startLeft+=_1;this.startTop+=_2;this.endLeft+=_1;this.endTop+=_2;this.setPoints(this.$45e());this.moved(_1,_2)}
);isc.B._maxIndex=isc.C+7;isc.GraphMath={polar2screen:function(_1,_2){var _3=Math.PI-((_1+450)%360)/180*Math.PI;return[_2*Math.cos(_3),-_2*Math.sin(_3)]},screen2polar:function(_1,_2){return[((Math.PI-Math.atan2(-_2,_1))/Math.PI*180+270)%360,Math.sqrt(Math.pow(_1,2)+Math.pow(_2,2))]},trimLineEnds:function(_1,_2,_3,_4,_5,_6){var _7=Math.sqrt(Math.pow(_3-_1,2)+Math.pow(_4-_2,2));if(_5+_6>_7){var _8=_5/(_5+_6)*(_3-_1)+_1;var _9=_5/(_5+_6)*(_4-_2)+_2;return[_8+(_1==_3?0:_1>_3?0.01:-0.01),_9+(_2==_4?0:_2>_4?0.01:-0.01),_8+(_1==_3?0:_1>_3?-0.01:0.01),_9+(_2==_4?0:_2>_4?-0.01:0.01)]}
var _10=Math.atan2(_2-_4,_3-_1);return[_1+(_5*Math.cos(_10)),_2-(_5*Math.sin(_10)),_3-(_6*Math.cos(_10)),_4+(_6*Math.sin(_10))]}}
isc.A=isc.Canvas.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.setCenter=function isc_Canvas_setCenter(_1,_2){this.moveTo(_1-this.getVisibleWidth()/2,_2-this.getVisibleHeight()/2)}
,isc.A.getCenter=function isc_Canvas_getCenter(){return[this.getLeft()+this.getVisibleWidth()/2,this.getTop()+this.getVisibleHeight()/2]}
);isc.B._maxIndex=isc.C+2;isc.defineClass("DrawKnob","Canvas");isc.A=isc.DrawKnob.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.width=10;isc.A.height=10;isc.A.overflow="hidden";isc.A.cursor="crosshair";isc.A.canDrag=true;isc.A.dragAppearance="target";isc.A.dragMove="return this.$64f()";isc.A.dragStop="return this.$64f()";isc.A.dragAppearance="none";isc.A.keepInParentRect=true;isc.A.autoDraw=false;isc.A.knobShapeDefaults={_constructor:isc.DrawOval,radius:5,lineWidth:2,fillColor:"#FF0000",fillOpacity:0.5,autoDraw:true,updateControlKnobs:function(){return},erase:function(){if(this.erasing)return;this.erasing=true;if(this.creator.isDrawn())this.creator.clear();this.Super("erase",arguments);delete this.erasing}};isc.B.push(isc.A.initWidget=function isc_DrawKnob_initWidget(){this.left=this.x-this.width/ 2;this.top=this.y-this.height/ 2}
,isc.A.setCenterPoint=function isc_DrawKnob_setCenterPoint(_1,_2,_3){var _4,_5;if(_3){var _6=this.drawPane.drawing2screen([_1-this.$44g/ 2,_2-this.$44h/ 2,0,0]);_4=_6[0],_5=_6[1]}else{_4=_1-this.width/ 2;_5=_2-this.height/ 2}
this.moveTo(_4,_5)}
,isc.A.draw=function isc_DrawKnob_draw(){if(!this.knobShape){this.knobShape=this.createAutoChild("knobShape",{drawPane:this.drawPane,centerPoint:[this.x,this.y]});this.drawPane.addCanvasItem(this)}else return this.Super("draw",arguments)}
,isc.A.moved=function isc_DrawKnob_moved(){if(!this.synchingToPane)this.updateKnobShape()}
,isc.A.$64f=function isc_DrawKnob__updatePoints(){var _1=isc.EH.getX()-
(this.drawPane.getPageLeft()+this.drawPane.getLeftMargin()+this.drawPane.getLeftBorderSize()),_2=isc.EH.getY()-
(this.drawPane.getPageTop()+this.drawPane.getTopMargin()+this.drawPane.getTopBorderSize());var _3=this.drawPane.screen2drawing([_1,_2,0,0]);var _4=_3[0],_5=_3[1],_6=_4-(this.$44e+this.$44g/ 2),_7=_5-(this.$44f+this.$44h/ 2);this.updatePoints(_4,_5,_6,_7)}
,isc.A.updateKnobShape=function isc_DrawKnob_updateKnobShape(){var _1=this.drawPane.screen2drawing([this.getLeft()+this.getWidth()/2,this.getTop()+this.getHeight()/2,0,0]);var x=_1[0],y=_1[1],_4=x-this.$44g/ 2,_5=y-this.$44h/ 2;this.$44e=_4,this.$44f=_5;this.knobShape.setCenterPoint(x,y)}
,isc.A.updatePoints=function(x,y,dX,dY){}
,isc.A.clear=function isc_DrawKnob_clear(){this.Super("clear",arguments);this.knobShape.erase()}
);isc.B._maxIndex=isc.C+8;isc.DrawKnob.registerStringMethods({updatePoints:"x,y,dX,dY"});isc._moduleEnd=isc._Drawing_end=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc.Log&&isc.Log.logIsInfoEnabled('loadTime'))isc.Log.logInfo('Drawing module init time: ' + (isc._moduleEnd-isc._moduleStart) + 'ms','loadTime');delete isc.definingFramework;}else{if(window.isc && isc.Log && isc.Log.logWarn)isc.Log.logWarn("Duplicate load of module 'Drawing'.");}

/*

  SmartClient Ajax RIA system
  Version SC_SNAPSHOT-2010-08-03/EVAL Deployment (2010-08-03)

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

