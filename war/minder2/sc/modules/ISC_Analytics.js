
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

if(window.isc&&window.isc.module_Core&&!window.isc.module_Analytics){isc.module_Analytics=1;isc._moduleStart=isc._Analytics_start=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc._moduleEnd&&(!isc.Log||(isc.Log && isc.Log.logIsDebugEnabled('loadTime')))){isc._pTM={ message:'Analytics load/parse time: ' + (isc._moduleStart-isc._moduleEnd) + 'ms', category:'loadTime'};
if(isc.Log && isc.Log.logDebug)isc.Log.logDebug(isc._pTM.message,'loadTime')
else if(isc._preLog)isc._preLog[isc._preLog.length]=isc._pTM
else isc._preLog=[isc._pTM]}isc.definingFramework=true;isc.ClassFactory.defineClass("CubeGrid","ListGrid");isc.addGlobal("ReportViewer",isc.CubeGrid);isc.A=isc.CubeGrid.getPrototype();isc.A.$d4=null;isc.A.styleName="normal";isc.A.bodyStyleName="cubeGridBody";isc.A.backgroundColor=null;isc.A.showEdges=false;isc.A.showEmptyMessage=false;isc.A.defaultWidth=500;isc.A.defaultHeight=300;isc.A.overflow=isc.Canvas.IGNORE;isc.A.baseStyle="cubeCell";isc.A.alternateRecordStyles=true;isc.A.skinImgDir="images/CubeGrid/";isc.A.innerHeaderBaseStyle="innerHeader";isc.A.colHeaderBaseStyle="colHeader";isc.A.colHeaderLabelBaseStyle="colHeaderLabel";isc.A.rowHeaderBaseStyle="rowHeader";isc.A.rowHeaderLabelBaseStyle="rowHeaderLabel";isc.A.headerDefaults=isc.ListGrid.$24j;isc.A.headerButtonDefaults=isc.ListGrid.$24k;isc.A.headerHeight=22;isc.A.canAutoFitFields=false;isc.A.autoFetchData=true;isc.A.canGroupBy=false;isc.A.canFreezeFields=false;isc.A.showFacetValueContextMenus=true;isc.A.fieldVisibilitySubmenuTitle="Values";isc.A.canSelectValues=true;isc.A.canSelectHeaders=true;isc.A.autoSelectHeaders=true;isc.A.autoSelectValues="both";isc.A.headerButtonConstructor=null;isc.A.useCellRecords=true;isc.A.valueProperty="_value";isc.A.cellIdProperty="ID";isc.A.selectedProperty="$24l";isc.A.editByCell=true;isc.A.saveByCell=true;isc.A.selectOnEdit=false;isc.A.saveLocally=true;isc.A.neverValidate=true;isc.A.showAllRecords=false;isc.A.showAllColumns=false;isc.A.resizeFieldsInRealTime=false;isc.A.canDragSelect=true;isc.A.canSelectCells=true;isc.A.useCellRollOvers=true;isc.A.sortDirection=Array.ASCENDING;isc.A.canSortFacets=false;isc.A.canSortData=false;isc.A.canReorderFacets=true;isc.A.controlLabels={reorderHandle:"Move",minimize:"Minimize",maximize:"Maximize",sortUp:"Sort Up",sortDown:"Sort Down",closeBox:"Close"};isc.A.facetTitleAlign="center";isc.A.facetValueAlign="center";isc.A.cellAlign="center";isc.A.padTitles=true;isc.A.innerHeaderControlSize=13;isc.A.innerHeaderReorderHandleWidth=7;isc.A.defaultFacetWidth=100;isc.A.rollupValue="sum";isc.A.summaryBorder="1px solid black";isc.A.summaryValue="sum";isc.A.summaryTitle="Sum";isc.A.metricFacetId="metric";isc.A.canAcceptDrop=true;isc.A.fastCellUpdates=(isc.Browser.isIE&&isc.Browser.isWin&&isc.Browser.version>=5);isc.A.fetchDelay=300;isc.A.allowMismatchedHeaderBodyBorder=false;isc.A.bodyMinWidth=null;isc.A.bodyMinHeight=null;isc.A.bodyDefaults=isc.addProperties({},isc.ListGrid.getInstanceProperty("bodyDefaults"),{selectOnMouseDown:function(_1,_2,_3){var _4=this.parentElement;if(!(this.selection.cellIsSelected(_2,_3)&&isc.EH.rightButtonDown())){_4.deselectHeaders(_4.rowHeaders);_4.deselectHeaders(_4.colHeaders);if(_4.showRowFacetLabels!=false&&_4.rowFacetLabels)_4.rowFacetLabels.selection.deselectAll();_4.lastSelectionHeaderBar=null}
if(!_4.canSelectValues)return false;var _5=isc.EventHandler.lastEvent;if(_5.shiftKey||_5.ctrlKey){var _6=this.selection.lastSelectedCell[0],_7=this.selection.lastSelectedCell[1];_2=_4.findSelectionBoundary(_6,_2,_4.rowBoundaries);_3=_4.findSelectionBoundary(_7,_3,_4.colBoundaries)}
this.$24n=_2;this.$24o=_3;this.selection.selectOnMouseDown(this,_2,_3);return true},dragMove:function(){if(!this.canDragSelect)return true;if(!this.selection)return false;var _1=this.parentElement,_2=this.getNearestRowToEvent(),_3=this.getNearestColToEvent(),_4=this.selection.lastSelectedCell[0],_5=this.selection.lastSelectedCell[1];if(this==_1.body&&_1.canSelectValues==false)return false;var _6=_1.findSelectionBoundary(_4,_2,_1.rowBoundaries);var _7=_1.findSelectionBoundary(_5,_3,_1.colBoundaries);if(this==_1.headerGrid)_7=_3;this.selection.selectOnDragMove(this,_6,_7);return true},markForRedraw:function(_1){if(_1=="scrollRedraw"){var _2=this.parentElement;if(_2.headerGrid)_2.headerGrid.markForRedraw("body redrawing")}
return this.Super("markForRedraw",arguments)},getDrawArea:function(_1,_2){var _3=this.Super("getDrawArea",arguments);if(_2)return _3;var _4=this.parentElement;if(_4.rowHeaderGridMode){var _5=_4.headerGrid.getDrawArea();if(!_4.multiRowHeaders){_3[0]=_5[0];_3[1]=_5[1]}else{var _6=_4.innerRowFields,_7=_6[_5[0]],_8=_6[_5[1]],_9=0,_10=0,_11=true;for(var i=0;i<_6.length;i++){var _13=_6[i];if(_13==_7)_11=false;if(_11)_9+=_13.groupCount;_10+=_13.groupCount;if(_13==_8)break}
_3[0]=_9;_3[1]=_10-1}}else if(!_4.rowHeaderGridMode){var _9=_3[0];if(_9>0&&_4.rowHeights!=null){var _14=this.getAvgRowHeight()*_3[0];this.startSpace=_4.rowHeights.slice(0,_9).sum()-_14}else{this.startSpace=0}}
return _3}});isc.A=isc.CubeGrid.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.groupFacetId="groupFacet";isc.A.groupByRow=true;isc.A.$76l="row";isc.A.$76m="column";isc.A.inlinedFacetValueSeparator="_";isc.A.$502=[];isc.A.useFillerCells=true;isc.A.allowNamelessFields=true;isc.A.facetLabelMethods={mouseMove:function(){this.Super("mouseMove",arguments);return isc.EventHandler.STOP_BUBBLING},mouseOver:function(){this.Super("mouseOver",arguments);var _1=this.cubeGrid;if(_1.facetLabelOver){_1.convertToMethod("facetLabelOver");_1.facetLabelOver(this.facetId)}
if(_1.canHover){isc.Hover.setAction(_1,_1.$24p,[this.facetId],_1.hoverDelay)}
return isc.EventHandler.STOP_BUBBLING},mouseOut:function(){this.Super("mouseOut",arguments);var _1=this.cubeGrid;if(_1.canHover)isc.Hover.clear();if(_1.facetLabelOut){_1.convertToMethod("facetLabelOut");_1.facetLabelOut(this.facetId)}
return isc.EventHandler.STOP_BUBBLING},showContextMenu:function(){var _1=this.cubeGrid;_1.facetContextItems=null;if(_1.facetContextClick){isc.Func.replaceWithMethod(_1,"facetContextClick","facetId");if(_1.facetContextClick(this.facetId)==false)return false}
if(_1.showFacetContextMenus){if(!_1.facetContextMenu)_1.facetContextMenu=isc.Menu.create(_1.contextMenuProperties);if(!_1.facetContextItems)_1.facetContextItems=_1.makeFacetContextItems(this.facetId);if(isc.isAn.Array(_1.facetContextItems)&&_1.facetContextItems.length>0){_1.facetContextMenu.setData(_1.facetContextItems);_1.facetContextMenu.showContextMenu(_1)}
return false}else{return _1.showContextMenu()}},click:function(){this.cubeGrid.facetLabelClick(this)},doubleClick:function(){this.cubeGrid.facetLabelDoubleClick(this)}};isc.A.chartConstructor="FusionChart";isc.A.chartType="Column";isc.A.chartConfirmThreshold=2000;isc.A.chartOmitSums=true;isc.A.exportSeparatorString="\r\n";isc.A.exportFacetSeparatorString=" - ";isc.B.push(isc.A.initWidget=function isc_CubeGrid_initWidget(){var _1;this.Super(this.$oc);this.facetHeight=this.facetHeight||this.headerHeight;this.cellHeight=this.facetHeight=Math.max(this.cellHeight,this.facetHeight);this.rowFacets=this.rowFacets||(this.rows?this.rows.facets:null);this.columnFacets=this.columnFacets||(this.columns?this.columns.facets:null);this.rowFacetValues=this.rowFacetValues||(this.rows?this.rows.fields:null);this.columnFacetValues=this.columnFacetValues||(this.columns?this.columns.fields:null);this.controlLabels=this.controlLabels||this.controlAltText;this.facetValueGroups=this.facetValueGroups||this.fieldGroups;if(this.canPivot!=null)this.canMoveFacets=this.canPivot
if(this.flatRowAttributes&&this.rowFacetValues){this.logWarn("rowFacetValues or rows.fields specified with flatRowAttributes mode "+"enabled - ignoring manual field placement");this.rowFacetValues=null}
if(this.canResizeColumns!=null)this.canResizeFields=this.canResizeColumns;if(this.canReorderColumns!=null)this.canReorderFields=this.canReorderColumns;if(this.data!=null&&!(isc.isAn.Array(this.data)&&this.data.length==0)){if(this.initialCriteria&&this.dataSource){this.originalData=this.data;this.data=this.getDataSource().applyFilter(this.data,this.initialCriteria);this.criteria=this.initialCriteria}
this.deriveFacetValues()}
this.setFacets();this.setFacetValueGroups();this.setRows();this.setColumns()}
,isc.A.destroy=function isc_CubeGrid_destroy(){if(this.$24r)this.$24r.destroy();this.Super("destroy",arguments)}
,isc.A.bodyKeyPress=function isc_CubeGrid_bodyKeyPress(_1){if(this.selectionType!=isc.Selection.NONE&&this.data.getLength()>0){var _2=isc.EventHandler,_3=_1.keyName;if(this.canSelectCells){var _4=0,_5=0;if(_3=="Arrow_Up"){_4=-1}else if(_3=="Arrow_Down"){_4=1}else if(_3=="Arrow_Left"){_5=-1}else if(_3=="Arrow_Right"){_5=1}
if(_5!=_4){if(this.$24s(_4,_5)==false)return false}}
return this.Super("bodyKeyPress",arguments)}
return true}
,isc.A.$24s=function isc_CubeGrid__navigateToNextCell(_1,_2){var _3=this.getArrowKeyAction();if(_3=='none')return true;var _4=this.getFocusCell();var _5=_4[0],_6=_4[1];if(_5!=null&&_6!=null){_5+=_1;_6+=_2}else{_5=_6=0}
while(!this.recordIsEnabled(_5,_6)){if(_1!=0)_5+=_1;if(_2!=0)_6+=_2
if(_5<0||_6<0||_5>=this.numRows||_6>=this.numCols)return true}
this.clearLastHilite();this.$24v=_5;this.$24w=_6;if(_3=='select')this.$24x(_5,_6);if(_3=='focus')this.$24y(_5,_6);this.scrollCellIntoView(_5,_6);return false}
,isc.A.getFocusCell=function isc_CubeGrid_getFocusCell(){var _1,_2;if(this.$24v!=null&&this.$24w!=null){if((this.$24v==this.body.lastOverRow&&this.$24w==this.body.lastOverCol)||(this.$24v==this.body.$24n&&this.$24w==this.body.$24o))
{_1=this.$24v;_2=this.$24w}}
if(_1==null||_2==null){if(this.body.$24n!=null&&this.body.$24o!=null){_1=this.body.$24n;_2=this.body.$24o}else if(this.getSelection().getLength>0){var _3=this.getSelection();_1=_3[0].$24t;_2=_3[0].$24u}}
return[_1,_2]}
,isc.A.$24x=function isc_CubeGrid__generateCellClick(_1,_2){if(isc.isAn.Object(_1)){_2=_1.$24u;_1=_1.$24t}
if(_1==null||_2==null||_1<0||_2<0||_1>=this.numRows||_2>=this.numCols)return;this.body.selectOnMouseDown(this.getCellRecord(_1,_2),_1,_2)}
,isc.A.$24y=function isc_CubeGrid__hiliteCell(_1,_2){if(isc.isAn.Object(_1)){_2=_1.$24u;_1=_1.$24t}
if(_1==null||_2==null||_1<0||_2<0||_1>=this.numRows||_2>=this.numCols)return;this.body.lastOverRow=_1;this.body.lastOverCol=_2;this.body.setRowStyle(_1,null,_2)}
,isc.A.clearLastHilite=function isc_CubeGrid_clearLastHilite(){if(!this.body)return;this.$24v=null;this.$24z=null;var _1=this.body.lastOverRow,_2=this.body.lastOverCol;if(_1!=null&&_2!=null){delete this.body.lastOverRow;delete this.body.lastOverCol;if(this.showRollOver)
this.body.setRowStyle(_1,null,_2)}}
,isc.A.$240=function isc_CubeGrid__generateFocusRecordClick(){var _1=this.getFocusCell(),_2=_1[0],_3=_1[1];if(_2!=null&&_3!=null)this.$24x(_2,_3)}
,isc.A.$241=function isc_CubeGrid__generateFocusRecordDoubleClick(){return this.$240()}
,isc.A.$vk=function isc_CubeGrid__setTabIndex(_1,_2){this.Super("$vk",arguments);if(this.canTabToHeader){if(this.rowHeaders!=null)this.$242(this.rowHeaders,_1);if(this.colHeaders!=null)this.$242(this.colHeaders,_1);if(this.rowFacetLabels!=null)this.$242(this.rowFacetLabels,_1);if(this.colFacetLabels!=null)this.$242(this.colFacetLabels,_1)}}
,isc.A.$242=function isc_CubeGrid__setHeaderTabIndices(_1,_2){if(!isc.isAn.Array(_1))_1=[_1];for(var i=0;i<_1.length;i++){if(isc.isA.Canvas(_1[i]))_1[i].$vk(_2,false)}}
,isc.A.canEditCell=function isc_CubeGrid_canEditCell(_1,_2){if(!this.Super("canEditCell",arguments))return false;var _3=this.getCellFacetValues(_1,_2);for(var _4 in _3){var _5=this.getFacetValue(_4,_3[_4]).canEdit;if(_5!=null&&_5==false)return false}
return true}
,isc.A.getEditorName=function isc_CubeGrid_getEditorName(_1,_2){if(!this.inlinedFacet)return this.valueProperty;if(isc.isAn.Object(_2)){_2=_2.facet.values.findIndex("id",_2.id)}
return this.getValueProperty(_1,_2)}
,isc.A.$50u=function isc_CubeGrid__fireCellChanged(_1,_2,_3,_4,_5){var _6,_7=this.getValueProperty(_2,_3);if(_4[_7]===_6)return;this.$34a(_1,null,_4[_7],(_5?_5[_7]:null),_2,_3)}
,isc.A.$45p=function isc_CubeGrid__editorGetAutoComplete(){return null}
,isc.A.setEditValues=function isc_CubeGrid_setEditValues(_1,_2,_3,_4,_5,_6,_7){var _8=_1[0],_9=_1[1];if(this.getCellRecord(_8,_9)==null){if(!_2)_2={};var _10=this.getCellFacetValues(_8,_9);isc.addProperties(_2,_10)}
return this.invokeSuper(isc.CubeGrid,"setEditValues",_1,_2,_3,_4,_5,_6,_7)}
,isc.A.setEditValue=function isc_CubeGrid_setEditValue(_1,_2,_3,_4,_5){if(isc.isA.String(_2)){if(isc.isA.Number(_1)){this.logWarn("CubeGrid.setEditValue() passed:"+[_1,_2]+". This is not a valid identifier for cell record edit values");return}else{_2=this.getValueProperty(_1,_2)}}
return this.Super("setEditValue",[_1,_2,_3])}
,isc.A.$30y=function isc_CubeGrid__getEditValue(_1,_2){if(isc.isA.String(_2)&&!isc.isA.String(_1)){this.logWarn("CubeGrid.getEditValue() passed:"+[_1,_2]+". This is not a valid identifier for cell record edit values");return}
var _3=this.$300(_1,_2);return _3?_3[this.getValueProperty(_1,_2)]:null}
,isc.A.getEditedCell=function isc_CubeGrid_getEditedCell(_1,_2){if(isc.isA.Number(_2)){if(isc.isA.Number(_1)){this.logWarn("getEditedCell() unable to determine cell coordinates from data passed in."+" Please pass in either an editValues ID as the first parameter or a"+" rowNum and colNum.");return null}
_2=this.getEditSessionColNum(_1)}
return this.Super("getEditedCell",[_1,_2])}
,isc.A.getEditValues=function isc_CubeGrid_getEditValues(_1,_2){if(_1==null)return this.logWarn("getEditValues() called with no valuesID");if(_2==null&&isc.isAn.Array(_1)){_2=_1[1];_1=_1[0]}
var _3=(isc.isA.Number(_1)?_1:this.getEditSessionRowNum(_1)),_2=_2!=null?_2:this.getEditSessionColNum(_1);if(this.$30a&&(this.getEditRow()==_3)&&(this.getEditCol()==_2)){this.storeUpdatedEditorValue()}
return this.$300(_3,_2)}
,isc.A.clearEditValue=function isc_CubeGrid_clearEditValue(_1,_2,_3,_4){if(isc.isA.String(_2)&&!isc.isA.String(_1)){this.logWarn("CubeGrid.getEditValue() passed:"+[_1,_2]+". This is not a valid identifier for cell record edit values");return}
if(isc.isA.Number(_1)){_1=this.getEditValuesID(_1,_2)}
var _5=this.valueProperty;return this.Super("clearEditValue",[_1,_5,_3,_4])}
,isc.A.isEditingRecord=function isc_CubeGrid_isEditingRecord(_1,_2){return(this.getEditRow()==_1)&&(this.getEditCol()==_2)}
,isc.A.$336=function isc_CubeGrid__saveLocally(_1,_2){var _3=_1.rowNum,_4=_1.colNum,_5=_1.oldValues,_6=_1.values;var _7=this.getCellRecord(_3,_4);this.setRawCellValue(_7,_3,_4,_6,true);this.$339(_1,_2)}
,isc.A.displayUpdatedDSRecord=function isc_CubeGrid_displayUpdatedDSRecord(_1,_2,_3){var _4=this.getCellRecord(_1,_2);this.setRawCellValue(_4,_1,_2,_3,true);this.dataChanged()}
,isc.A.$50r=function isc_CubeGrid__displayNewEditValues(_1,_2,_3,_4){var _5;if(!_3||_3[this.valueProperty]===_5)return;var _6=this.isEditingRecord(_1,_2)&&this.$286!=null
var _7=this.getValueProperty(_1,_2);if(_6){this.getEditForm().setValue(_7,_3[_7])}else{this.refreshCell(_1,_2)}}
,isc.A.findRowNum=function isc_CubeGrid_findRowNum(_1,_2){if(this.cellIndex==null)this.indexCellRecords();if(!this.inlinedFacets){if(_1.$24t!=null)return _1.$24t;var _3=this.getCellRow(_1);if(_3!=-1)return _3}
if(_2&&_2.$507){var _4=_2.$507;return this.getFacetValuesOffset(_4,this.rowFacets,this.rowFields.first())}
if(!this.dataSource)return-1;var _5=this.data.findByKeys(_1,this.getDataSource());if(_5==-1)return-1;return this.data[_5].$24t}
,isc.A.findColNum=function isc_CubeGrid_findColNum(_1,_2){if(this.cellIndex==null)this.indexCellRecords();if(!this.inlinedFacets){if(_1.$24u!=null)return _1.$24u;var _3=this.getCellColumn(_1);if(_3!=-1)return _3}
if(_2&&_2.$507){var _4=_2.$507;return this.getFacetValuesOffset(_4,this.columnFacets,this.colFields.first())}
if(!this.dataSource)return-1;var _5=this.data.findByKeys(_1,this.getDataSource());if(_5==-1)return-1;return this.data[_5].$24u}
,isc.A.$52p=function isc_CubeGrid__calculateEditCell(_1,_2,_3,_4,_5){if(_1.$33i){var _6,_7,_8=this.rowFields[0],_9=this.colFields[0],_10=this.haveColumnFacets(),_11=this.haveRowFacets();_6=(!_11?0:this.getFacetValuesOffset(_1.$31x,this.rowFacets,_8,true));_7=(!_10?0:this.getFacetValuesOffset(_1.$31x,this.columnFacets,_9,true));return[_6,_7]}else return this.invokeSuper(isc.CubeGrid,"$52p",_1,_2,_3,_4,_5)}
,isc.A.$50s=function isc_CubeGrid__moveEditor(_1,_2,_3){if(!this.$30a||(_1==this.$285&&_2==this.$30u))return;var _4=this.$285,_5=this.$30u;this.$285=_1;this.$30u=_2;var _6=this.getEditFormItem(_5);_6.rowNum=_1;_6.colNum=_2}
,isc.A.getEditValuesID=function isc_CubeGrid_getEditValuesID(_1,_2){var _3=isc.isA.Number(_1);if(_1==null||(_3&&_2==null)||this.$52b==null)return null;if(isc.isA.String(_1)&&this.$52b[_1]!=null)return _1;for(var i in this.$52b){var _5=this.$52b[i];if(_3){if(_5.$24t==_1&&_5.$24u==_2)return i}else{if(_5==_1)return i;if(this.comparePrimaryKeys(this.$52b[i].$33b,_1)){return i}}}
return null}
,isc.A.setRowEditFieldName=function isc_CubeGrid_setRowEditFieldName(){}
,isc.A.getRowEditColNum=function isc_CubeGrid_getRowEditColNum(){}
,isc.A.getRawCellValue=function isc_CubeGrid_getRawCellValue(_1,_2,_3){var _4=this.$300(_2,_3),_5=this.getEditorName(_2,_3),_6;if(_4&&_4[_5]!==_6){return _4[_5]}
if(_1==null)_1=this.getCellRecord(_2,_3);if(_1!=null)return _1[this.getValueProperty(_2,_3)]}
,isc.A.setRawCellValue=function isc_CubeGrid_setRawCellValue(_1,_2,_3,_4,_5){if(_1==null)_1=this.getCellRecord(_2,_3)
if(_1==null){_1={};isc.addProperties(_1,this.getCellFacetValues(_2,_3));this.data.add(_1);if(this.cellIndex){var _6=this.getCellRecord(_2,_3,true);if(_6)this.$52q.remove(_6);_1.$24t=_2;_1.$24u=_3;this.cellIndex[_3][_2]=_1}}
isc.addProperties(_1,_4);if(_5)this.$50w=true;this.data.dataChanged();if(_5)delete this.$50w}
,isc.A.getEditorConstructor=function isc_CubeGrid_getEditorConstructor(_1,_2){return this.editor}
,isc.A.getCellField=function isc_CubeGrid_getCellField(_1,_2){if(this.innerColFields!=null)return this.innerColFields[_2]}
,isc.A.$243=function isc_CubeGrid__editNextItem(_1,_2,_3){do{_2+=_3;if(_2>=this.numCols){_2=0;_1+=1}else if(_2<0){_2=this.numCols-1;_1-=1}
if(_1<0||_1>=this.numRows)return false}while(!this.handleEditCellEvent(_1,_2))}
,isc.A.deriveFacetValues=function isc_CubeGrid_deriveFacetValues(_1){var _2=this.rowFacets.concat(this.columnFacets),_3=[];for(var i=0;i<_2.length;i++){var _5=_2[i];var _6=null;if(!_1&&this.facets)_6=this.facets.find("id",_5);_6=_6||{id:_5};var _7=this.getDataSource();if(_7!=null&&_7.getField(_6.id)!=null){_6.name=_6.id;_6=_7.combineFieldData(_6)}
_6.title=_6.title!=null?_6.title:_6.id;_3.add(_6);if(_6.values&&!_1)continue;if(_6.getValueTitle&&!isc.isA.Function(_6.getValueTitle)){isc.Func.replaceWithMethod(_6,"getValueTitle","value,facet,grid")}
_6.values=[];var _8={};for(var j=0;j<this.data.getLength();j++){var _10=this.data.get(j),_11=_10[_5],_12=_11;if(_8[_11])continue;if(_6.getValueTitle){_12=_6.getValueTitle(_11,_6,this)}else if(_6.autoDeriveTitles||(_6.autoDeriveTitles==null&&this.autoDeriveTitles))
{_12=isc.DS.getAutoTitle(_12)}
var _13={id:_11,title:_12};_6.values.add(_13);_8[_11]=_13}
if(_6.values.length==null){this.logWarn("Could not generate any facetValues for facet '"+_5+"', does facetId match fieldName in provided dataset?")}}
this.facets=_3}
,isc.A.setFacets=function isc_CubeGrid_setFacets(_1){_1=this.facets=_1||this.facets;var _2=this.groupFacetId;var _3=_1.find("id",_2);if(_3){_1.remove(_3);this.rowFacets.remove(_2);this.columnFacets.remove(_2)}
this.facetIndex=this.facets.makeIndex("id");for(var i=0;i<this.facets.length;i++){var _5=this.facets[i];if(_5.inlinedValues){if(this.inlinedFacet&&_5!=this.inlinedFacet){this.inlinedFacets=[this.inlinedFacet,_5]}else{this.inlinedFacet=_5}}}
var _6=this.facetValuePivots;if(_6&&!this.$76n){for(var i=0;i<_6.length;i++){var _7=_6[i];this.pivotFacetValue(_7.facetId,_7.facetValueId,_7.parentFacetValues,_7.pivotValues,true)}
this.$76n=true}
var _8=this.data;if(this.multiCellData&&this.data){var _9=isc.timeStamp();var _10=false;if(this.pivotWithinFacet){_10=this.getFacetLocation(this.pivotWithinFacet).isRow}
var _11=this.getAllFacetIds(_10);if(this.inlinedFacet){_11.remove(this.inlinedFacet.id)}
var _12=isc.Tree.create({modelType:"fields",fieldOrder:_11})
_12.connectByFields(_8);var _13=_12.getLevelNodes(_11.length-1),_14=0,_15={},_16=_11.slice(_11.length-2);this.groupedTotalRows=0;for(var j=0;j<_13.length;j++){var _18=_13[j],_19=_12.getChildren(_18);if(!this.groupingAsFacet){var _20=this.getSideFacetValues(_19[0]),_21=this.getFieldProperty(_20,"groupCount");if(_21==null){this.setFieldProperty(_20,"groupCount",_19.length);this.groupedTotalRows+=_19.length}else{var _22=Math.max(_19.length,_21);if(_19.length>_21){this.groupedTotalRows+=(_19.length-_21);this.setFieldProperty(_20,"groupCount",_22)}}}
var _23=_12.getParent(_18);_15[_11.last()]=_12.getTitle(_18);_15[_11[_11.length-2]]=_12.getTitle(_23);var _24=this.getFieldProperty(_15,"pivot",_16);if(!_24||_24.pivotFacetValueId==null){_14=Math.max(_19.length-1,_14);for(var i=0;i<_19.length;i++){_19[i][_2]=i}
continue}
var _25=this.inlinedFacet&&this.inlinedFacet.id==this.pivotWithinFacet?_24.pivotFacetValueId:this.valueProperty;var _26=_19.makeIndex(_25,true);for(var _27 in _26){var _28=_26[_27];_14=Math.max(_28.length-1,_14);for(var i=0;i<_28.length;i++){_28[i][_2]=i}}}
this.logInfo("generated groupFacet by grouping across: "+_11+", max index: "+_14,"facetValuePivot");if(this.groupingAsFacet){var _3={id:_2,title:"Group",width:1,height:1}
var _29=[];for(var i=0;i<=_14;i++){_29.add({id:i,title:i})}
_3.values=_29;_1.add(_3);this.facetIndex[_2]=_3;if(this.groupByRow){this.rowFacets.add(_2)}else{this.columnFacets.add(_2)}}else{this.multiRowHeaders=true}
this.logInfo("multiCellData group generation: "+(isc.timestamp()-_9)+"ms","cgTiming")}
for(var i=0;i<this.facets.length;i++){var _5=this.facets[i],_29=_5.values;if(_5.border)_5.bodyBorder=_5.border;if(_29==null)continue;_5.valuesIndex={};for(var j=0;j<_29.length;j++){var _30=_29[j];if(_30==null&&!(this.flatRowAttributes&&this.rowAttributeLOD)){this.logWarn("null facet value at facet "+_5.id+" index "+j);continue}
if(_30.id==null){_30.id=j}
_30.facetValueId=_30.id;_30.facet=_5;_5.valuesIndex[_30.id]=_30}
if(_5.isTree){_5.values.setProperty("$244",null);var _31=isc.Tree.create({showRoot:false,data:_5.values,modelType:"parent",parentIdField:"parentId",childrenProperty:"$244",isOpen:function(_32){return!_32.collapsed}});for(var j=0;j<_29.length;j++){var _30=_29[j];_30.$245=(_30.collapsed!=null?_30.collapsed:_5.collapsed)}
_5.$246=_31}}
this.$24q()}
,isc.A.getFacet=function isc_CubeGrid_getFacet(_1){if(isc.isA.String(_1))return this.facetIndex[_1];return _1}
,isc.A.getFacetValue=function isc_CubeGrid_getFacetValue(_1,_2){var _3=this.getFacet(_1);if(_3==null){this.logWarn("Can't get facetValue: "+_2+" because there is no such facetId: "+_1+this.getStackTrace());return null}
return _3.valuesIndex[_2]}
,isc.A.haveColumnFacets=function isc_CubeGrid_haveColumnFacets(){return(this.columnFacets!=null&&this.columnFacets.length>0)}
,isc.A.haveRowFacets=function isc_CubeGrid_haveRowFacets(){return(this.rowFacets!=null&&this.rowFacets.length>0)}
,isc.A.getAllFacetIds=function isc_CubeGrid_getAllFacetIds(_1){var _2=[];if(_1){if(this.haveColumnFacets())_2=_2.concat(this.columnFacets);if(this.haveRowFacets())_2=_2.concat(this.rowFacets)}else{if(this.haveRowFacets())_2=_2.concat(this.rowFacets);if(this.haveColumnFacets())_2=_2.concat(this.columnFacets)}
return _2}
,isc.A.setFacetValueGroups=function isc_CubeGrid_setFacetValueGroups(_1){_1=this.facetValueGroups=_1||this.facetValueGroups;if(_1==null)return;this.$247=_1.makeIndex("id")}
,isc.A.getFacetValueGroup=function isc_CubeGrid_getFacetValueGroup(_1){if(this.facetValueGroups==null)return null;return this.$247[_1]}
,isc.A.$24q=function isc_CubeGrid__detectAllFacetValuesPresent(){this.facetValuesPresent=this.facetValuesPresent||{};this.$248()}
,isc.A.$248=function isc_CubeGrid__markAllValuesPresent(_1){var _2=isc.timeStamp();_1=_1||this.data;for(var i=0;i<_1.length;i++){var _4=_1[i];if(!this.inlinedFacet){var _5=_4[this.valueProperty];if(_5==null||_5==this.emptyValue)continue}
if(this.haveRowFacets())this.markValuesPresent(_4,this.rowFacets);if(this.haveColumnFacets())this.markValuesPresent(_4,this.columnFacets)}
var _6=isc.timeStamp();this.logInfo("markValuesPresent: "+_1.length+" cellRecords: "+(_6-_2)+"ms","cgTiming")}
,isc.A.facetValuesArePresent=function isc_CubeGrid_facetValuesArePresent(_1,_2){if(this.hideEmptyAxis!=null){var _3=this.facetPathIsRow(_1);if(!_3){if(this.hideEmptyAxis==this.$76l)return true}else{if(this.hideEmptyAxis==this.$76m)return true}}
return(this.getFieldProperties(_1,_2)!=null)}
,isc.A.setFieldProperty=function isc_CubeGrid_setFieldProperty(_1,_2,_3){var _4,_5;if(isc.isAn.Object(_1.facet)){_5=_1.isRowHeader?this.rowFacets:this.columnFacets;_4=this.getHeaderFacetValues(_1)}else{_4=_1}
if(!this.facetValuesPresent)this.facetValuesPresent={};this.markValuesPresent(_4,_5);var _6=this.getFieldProperties(_4,_5);_6[_2]=_3}
,isc.A.markValuesPresent=function isc_CubeGrid_markValuesPresent(_1,_2){_2=_2||this.getFacetsForPath(_1);var _3=this.logIsInfoEnabled("ignoredRecords");var _4=this.facetValuesPresent,_5,_6,_7=false,_8=null;for(var i=0;i<_2.length;i++){var _10=_2[i];if(!this.inlinedFacet||_10!=this.inlinedFacet.id){if(_1[_10]==null){if(_7&&_6!=null){_5[_6]=null}
if(_3){this.logInfo("no value found for facetId: "+_10+" ignoring cellRecord: "+isc.echo(_1),"ignoredRecords")}
break}
var _8=_1[_10];if(_4[_8]==null){_4[_8]={};_7=true}else{_7=false}}else{var _11=this.inlinedFacet.values,_12,_13=false;for(var j=0;j<_11.length;j++){var _8=_11[j].id;if(_1[_8]!==_12){_4[_8]={};_13=true}}
if(!_13&&_7&&_6!=null){_5[_6]=null;if(_3){this.logInfo("no values found for facetId: "+_10+" ignoring cellRecord: "+isc.echo(_1),"ignoredRecords")}}}
_5=_4;_6=_8;_4=_4[_8]}}
,isc.A.facetPathIsRow=function isc_CubeGrid_facetPathIsRow(_1){var _2;for(_2 in _1)break;return this.getFacetLocation(_2).isRow}
,isc.A.getFacetsForPath=function isc_CubeGrid_getFacetsForPath(_1){var _2=this.facetPathIsRow(_1),_3=_2?this.rowFacets:this.columnFacets;return _3.slice(0,isc.getKeys(_1).length)}
,isc.A.getFieldProperties=function isc_CubeGrid_getFieldProperties(_1,_2){_2=_2||this.getFacetsForPath(_1);var _3=this.facetValuesPresent;for(var i=0;i<_2.length;i++){var _5=_2[i],_6=_1[_5];if(_6==null)return _3;if(_3==null)return null;if(_3[_6]==null)return null;_3=_3[_6]}
return _3}
,isc.A.getFieldProperty=function isc_CubeGrid_getFieldProperty(_1,_2,_3){var _4=this.getFieldProperties(_1,_3),_5;return _4?_4[_2]:_5}
,isc.A.setRows=function isc_CubeGrid_setRows(_1,_2,_3){if(this.isDrawn()){if(this.rowHeaders!=null){this.rowHeaders.map("destroy");this.rowHeaders=null}
if(this.rowFacetLabels!=null&&!_2){this.rowFacetLabels.destroy();this.rowFacetLabels=null}
if(this.headerGrid!=null){this.headerGrid.destroy();this.headerGrid=null}}
this.$249();this.rowHeaders=[];if(this.isDrawn()){if(!_2)this.createRowFacetLabels();this.createRowHeaderBars(true);this.layoutChildren();this.map("addChild",this.rowHeaders);this.$25a("setRows");this.syncHeaderScrolling()}
this.cellIndex=null;if(!_3&&this.$52b&&!isc.isA.emptyObject(this.$52b)){this.$31n()}}
,isc.A.$249=function isc_CubeGrid__buildRowFields(){this.numRows=1;if(this.haveRowFacets()){if(this.showColumnSummary)this.$25b();this.rowNesting=false;this.$25c=this.$25d=this.$25e=this.$25f=null;var _1=this.facets.find("combineInTree",true);if(_1){if(!(this.rowFacets&&this.rowFacets.length>1&&this.rowFacets.last()==_1.id))
{this.logWarn("ignoring bad combineInTree property on facet: "+_1.id)}else{this.$25d=_1.id;this.$25e=this.rowFacets[this.rowFacets.length-2];this.$25c=true}}
if(this.flatAttributesOnly()){this.rowFields=[];for(var i=0;i<this.rowFacets.length;i++){this.rowFields[i]=this.getFacet(this.rowFacets[i]).values}}else{this.rowFields=this.makeFieldTree({facets:this.rowFacets,fields:this.rowFacetValues},true)}
this.innerRowFields=this.rowFields.last();if(this.rowAttributeLOD)this.$25g();if(this.$25c)this.$25h();this.numRows=this.groupedTotalRows||this.innerRowFields.length;this.rowBorders=this.getBorderStyles(this.innerRowFields,true);this.rowBoundaries=this.getSelectionBoundaries(this.innerRowFields)}else{this.rowFields=[];this.innerRowFields=[];this.rowBorders=[];this.numRows=1;this.rowBoundaries=null}
var _3=this.selection.data;for(var i=0;i<this.numRows;i++)_3[i]={}}
,isc.A.inMultiFacetColumn=function isc_CubeGrid_inMultiFacetColumn(_1){if(!this.$25c)return false;if(_1==this.$25d||_1==this.$25e)return true;return false}
,isc.A.$25h=function isc_CubeGrid__buildCrossFacetTree(){var _1=isc.Tree.create({showRoot:false,root:{name:"/",childFacetValues:this.rowFields[this.rowFacets.length-2]},childrenProperty:"childFacetValues",isOpen:function(_3){return!_3.minimized},nameProperty:"$25i",pathProperty:"$25j",parentProperty:"$25k"});this.$25f=_1;var _2=_1.getOpenList();if(this.getFacet(this.$25e).showParentsLast)_2=_2.reverse();_1.$25l=_2;this.innerRowFields=_2}
,isc.A.getTotalRows=function isc_CubeGrid_getTotalRows(){return this.numRows}
,isc.A.setColumns=function isc_CubeGrid_setColumns(_1,_2,_3){if(this.isDrawn()){if(this.colHeaders!=null){this.colHeaders.map("destroy");this.colHeaders=null}
if(this.colFacetLabels!=null&&!_2){this.colFacetLabels.destroy();this.colFacetLabels=null}}
_1=this.columns=_1||this.columns;this.numCols=1;if(this.haveColumnFacets()){var _4=isc.timeStamp();this.colFields=this.makeFieldTree({facets:this.columnFacets,fields:this.columnFacetValues});this.innerColFields=this.colFields.last();this.fields=this.innerColFields;this.numCols=this.innerColFields.length;this.colBorders=this.getBorderStyles(this.innerColFields);this.colBoundaries=this.getSelectionBoundaries(this.innerColFields)}else{this.colFields=[];this.innerColFields=[];this.colBorders=[];this.fields=[{name:"$25m",width:100}];this.numCols=1;this.colBoundaries=null}
this.colHeaders=[];if(this.isDrawn()){if(this.haveColumnFacets()){this.sizeParentFields(this.colFields,this.colHeaders,"width",this.defaultFacetWidth)}
if(!_2)this.createColumnFacetLabels();this.createColumnHeaderBars(true);this.setFields(this.fields,this.getFieldWidths());this.layoutChildren();this.map("addChild",this.colHeaders);this.$25a("setColumns");this.syncHeaderScrolling()}
this.cellIndex=null;if(!_3&&this.$52b&&!isc.isA.emptyObject(this.$52b)){this.$31n()}}
,isc.A.makeFieldTree=function isc_CubeGrid_makeFieldTree(_1,_2){var _3=isc.timeStamp();this.fieldTree=[];this.isRowHeader=_2;this.facetIds=_1.facets;this.$25n=0;for(var i=0;i<this.facetIds.length;i++)this.fieldTree[i]=[];this.makeFieldTreeLevel(this.getChildFacetValues(null,_1,this.facetIds[0]),0);var _5=this.fieldTree;if(this.$25n>0){this.logInfo(this.$25n+" fields suppressed by hideEmptyFacetValues")}
this.fieldTree=null;this.isRowHeader=null;this.facetIds=null;this.$25n=null;var _6=isc.timeStamp();if(this.logIsDebugEnabled("cgTiming")){this.logDebug("makeFieldTree("+(_2?"rows":"cols")+"): "+(_6-_3)+"ms","cgTiming")}
return _5}
,isc.A.makeFieldTreeLevel=function isc_CubeGrid_makeFieldTreeLevel(_1,_2,_3,_4){if(_1==null)return;var _5=this.facetIds[_2],_6=this.getFacet(_5);if(_1!=null&&this.pivotWithinFacet==_5){_1=this.getPivotFacetValues(_3,_5,_1)||_1}
for(var i=0;i<_1.length;i++){var _8=_1[i];if(_8==null){this.logWarn("Null facetValue at index "+i+" in facet "+_5);continue}
var _9=null;if(isc.isAn.Object(_8)){_9=_8;_8=_9.facetValueId}
var _10=this.getFacetValue(_5,_8);if(_10==null){this.logWarn("No such facetValue "+_8+" in facet "+_5);continue}
var _11=null,_12=null;if(_10.hidden){_12=this.getHeaderFacetValues(_3);_12[_5]=_8;_11=this.getFieldProperties(_12,this.facetIds);if(!_11||_11.hidden!==false)continue}
var _13=this.makeField(_6,_10,_2,_4);if(_9){isc.addProperties(_13,_9)}
if((this.hideEmptyFacetValues&&!this.attributesOnly())||this.canCollapseFacets||this.canMinimizeFacets||this.multiRowHeaders)
{if(_3!=null)_13.parent=_3;_12=_12||this.getHeaderFacetValues(_13);if(this.hideEmptyFacetValues&&!this.attributesOnly()){if(!this.facetValuesArePresent(_12,this.facetIds)){this.$25n++;if(this.logIsInfoEnabled()){this.logInfo("Suppressing header for facetValues: "+this.echo(_12))}
continue}}
if(this.canCollapseFacets||this.canMinimizeFacets||this.canPickFields||this.multiRowHeaders)
{_11=_11||this.getFieldProperties(_12);if(_11!=null){if(_11.hidden){if(this.logIsDebugEnabled()){this.logDebug("skipping hidden field, props: "+this.echo(_11)+" at facetValues: "+this.echo(_12))}
continue}
isc.addProperties(_13,_11)}}}
this.deriveFieldBorders(_13,_6,_3,_1,i);if(this.fieldTree[_2]==null)this.fieldTree[_2]=[];this.fieldTree[_2].add(_13);var _14=this.fieldTree[_2].length-1;if(_3!=null){_13.parent=_3;if(_3.childFacetValues==null)_3.childFacetValues=[];_3.childFacetValues.add(_13);if(_3.childFacetValues.length>1){if(this.isRowHeader)this.rowNesting=true}}
var _15=this.facetIds[_2+1],_16=this.getChildFacetValues(_5,_1[i],_15,_13,_14);if(_16!=null){this.isLastInLevel=(i==_1.length-1)
this.makeFieldTreeLevel(_16,_2+1,_13,this.$25o)}}
if(this.isRowHeader&&this.showColumnSummary&&this.isLastInLevel){this.$25p(_6,_2,this.fieldTree)}}
,isc.A.makeField=function isc_CubeGrid_makeField(_1,_2,_3,_4){var _5;if(this.flatRowAttributes){_5=_2}else if(_1.id==this.groupFacetId||this.facetValueFieldProperties){_5={id:_2.id,facetValueId:_2.id,facet:_1,title:_2.title};if(this.facetValueFieldProperties){var _6=this.facetValueFieldProperties,_5={};for(var i=0;i<_6.length;i++){_5[_6[i]]=_2[_6[i]]}}}else{_5=isc.addProperties({},_2)}
if(_5.border)_5.bodyBorder=_5.border;_5.border=null;if(_4!=null)_5.facetValueGroup=_4;if(_2.titleHilite!=null||_1[this.hiliteProperty]!=null){_5.$25q=(_2.titleHilite!=null?_2.titleHilite:_1[this.hiliteProperty]);_5.cssText=this.addObjectHilites(_5.$25q)}
if(this.isRowHeader)_5.isRowHeader=this.isRowHeader;_5.headerLevel=_3;var _8=this.isRowHeader?this.rowFacets.length:this.columnFacets.length;if(_3!=_8-1)_5.childFacetValues=[];_5.showCloseBox=(_2.canClose!=null?_2.canClose:_1.canClose!=null?_1.canClose:this.canCloseColumns);_5.showSortButtons=(_2.canSort!=null?_2.canSort:_1.canSort!=null?_1.canSort:this.canSortData);_5.canCollapse=(_1.isTree&&_2.canCollapse!=false&&_1.canCollapse!=false&&this.canCollapseFacets!=false);_5.canMinimize=(_2.canMinimize!=null?_2.canMinimize:_1.canMinimize!=null?_1.canMinimize:this.canMinimizeFacets);_5.cellAlign=_5.cellAlign||_1.cellAlign||_2.align||_1.align||this.cellAlign;_5.align=_5.align||_1.align||this.facetValueAlign;return _5}
,isc.A.deriveFieldBorders=function isc_CubeGrid_deriveFieldBorders(_1,_2,_3,_4,_5){var _6;if(_5==0&&_3&&_3.$25r){_6=_3.$25r}else{_6=_1.borderBefore||_2.borderBefore}
if(_6){_1.$25r=_6;_6="border-"+(this.isRowHeader?"top":"left")+":"+_6+isc.semi;if(_1.cssText)_1.cssText+=_6;else _1.cssText=_6}
if(_5==_4.length-1&&_3&&_3.$25s){_6=_3.$25s}else{_6=_1.borderAfter||_2.borderAfter}
if(_6){_1.$25s=_6;_6="border-"+(this.isRowHeader?"bottom":"right")+":"+_6+isc.semi;if(_1.cssText)_1.cssText+=_6;else _1.cssText=_6}}
,isc.A.getChildFacetValues=function isc_CubeGrid_getChildFacetValues(_1,_2,_3,_4,_5){var _6=this.$25t(_1,_2,_3,_4,_5);if(this.$25c&&_3==this.$25d){var _7=this.getRollupValue(this.$25d);if(_7&&_6.contains(_7.id))_6.remove(_7.id)}
return _6}
,isc.A.$25t=function isc_CubeGrid__getChildFacetValues(_1,_2,_3,_4,_5){if(_2.facetValueGroup!=null||_2.fieldGroup!=null){var _6=_2.facetValueGroup||_2.fieldGroup,_7=this.getFacetValueGroup(_6);if(_7!=null){_7.facetId=_3;this.$25o=_6;return _7.facetValues||_7.values||_7.fields}}
this.$25o=null;if(_2.fields)return _2.fields;var _8=this.getFacet(_3);if(_8==null||_8.values==null){return null}
if(_8.syncChanges!=false&&_8.synchColumnLayout!=false){this.$25o=_8.id}
if(_1!=null){_2=(isc.isA.String(_2)?this.getFacetValue(_1,_2):_2);var _9=this.getFacet(_1),_10;if(_4!=null&&_4.minimized!=null){_10=_4.minimized}else{_10=_9?_9.minimized:false}
if(_10){_4.minimized=true;if(this.$25c&&_1==this.$25e){return[]}else{return this.getMinimizeValues(_3)}}}
if(_8.isTree){var _11=_8.$246;var _12=(_4!=null?this.getHeaderFacetValues(_4):{});for(var i=0;i<_8.values.length;i++){var _14=_8.values[i];_12[_3]=_14.id;var _15=this.getFieldProperties(_12);if(_15!=null&&_15.collapsed!=null){_14.collapsed=_15.collapsed}else{_14.collapsed=_14.$245}}
var _16=_11.getOpenList().getProperty("id");if(_8.showParentsLast&&!(this.inMultiFacetColumn(_8.id)&&this.getFacet(this.$25e).showParentsLast))
{_16=_16.reverse()}
return _16}
if(this.flatRowAttributes&&this.isRowHeader){if(_5==null)return _8.values;else return[_8.values[_5].id]}
var _17=_8.values.getProperty("id");var _18=_8.values.last();if(_18&&_18.$25u){_17.length=_17.length-1}
return _17}
,isc.A.getMinimizeValues=function isc_CubeGrid_getMinimizeValues(_1){var _2=this.getFacet(_1);var _3=_2.values.findAll("isMinimizeValue","true");if(_3!=null)return _3;_3=this.getRollupValue(_1);if(_3!=null)return[_3];return[_2.values.last()]}
,isc.A.getRollupValue=function isc_CubeGrid_getRollupValue(_1){var _2=this.getFacet(_1),_3=_2.rollupValue||this.rollupValue;if(_3!=null)return this.getFacetValue(_1,_3)}
,isc.A.checkValidCube=function isc_CubeGrid_checkValidCube(){var _1=this.getAllFacetIds();for(var i=0;i<_1.length;i++){var _3=_1[i],_4=this.getFacet(_3);if(!_4){this.logWarn("No definition for facet: "+_3);continue}
if(!_4.values||!isc.isAn.Array(_4.values)||_4.values.length==0){isc.logWarn("Visible facet "+_3+" has no specified facetValues "+"and no values for this facet were present in cube.data")}}
if(this.haveRowFacets())this.checkFieldTree(true);if(this.haveColumnFacets())this.checkFieldTree(false)}
,isc.A.checkFieldTree=function isc_CubeGrid_checkFieldTree(_1){var _2=_1?this.rowFacets:this.columnFacets,_3=_1?this.rowFields:this.colFields;for(var j=0;j<_3.length-1;j++){var _5=_3[j];for(var i=0;i<_5.length;i++){var _7=_5[i],_8=_7.childFacetValues;if(!_8||!isc.isAn.Array(_8)||_8.length==0){isc.logWarn("Invalid cube: no facetValues at path: "+this.echo(this.getHeaderFacetValues(_7)))}}}}
,isc.A.$25b=function isc_CubeGrid__addRowFacetSumValues(){for(var i=0;i<this.rowFacets.length;i++){var _2=this.getFacet(this.rowFacets[i]);if(!_2.values.last().$25u){var _3={id:_2.summaryValue||this.summaryValue,title:_2.summaryTitle||this.summaryTitle,facet:_2,selectionBoundary:"before",$25r:this.summaryBorder,$25u:true}
_3[this.hiliteProperty]=this.summaryHilite;_2.values.add(_3);_2.valuesIndex[_3.id]=_3}}}
,isc.A.$25p=function isc_CubeGrid__addSumValueToLevel(_1,_2,_3){var _4=this.getFacetValue(_1.id,_1.summaryValue||this.summaryValue),_5=this.makeField(_1,_4,_2);if(this.summaryBorder){var _6="border-top:"+this.summaryBorder+isc.semi;if(_5.cssText)_5.cssText+=_6;else _5.cssText=_6}
if(this.fieldTree[_2+1]!=null){var _7=_3[_2+1].last();_7.parent=_5;_5.childFacetValues=[_7]}
if(_3[_2]==null)_3[_2]=[];_3[_2].add(_5)}
,isc.A.getBoundaryProperty=function isc_CubeGrid_getBoundaryProperty(_1,_2,_3){if(_1==null)return null;var _4;while(true){_4=(_1[_2]||_1.facet[_2]||_4);var _5=_1.parent;if(_5&&((_3&&_5.childFacetValues.first()==_1)||(!_3&&_5.childFacetValues.last()==_1)))
{_1=_1.parent}else break}
return _4}
,isc.A.getSelectionBoundaries=function isc_CubeGrid_getSelectionBoundaries(_1){var _2=[];for(var i=0;i<_1.length;i++){var _4=_1[i];var _5=this.getBoundaryProperty(_4,"selectionBoundary");if(_5){if(_5=="both"){_2[i]=_2[i-1]=true}else if(_5=="before"){_2[i-1]=true}else{_2[i]=true}}}
return _2}
,isc.A.findSelectionBoundary=function isc_CubeGrid_findSelectionBoundary(_1,_2,_3){if(_3==null)return _2;var _4=Math.min(_1,_2),_5=Math.max(_1,_2);for(var _6=_4;_6<_5;_6++){if(_3[_6]){return(_2>_1?_6:_6+1)}}
return _2}
,isc.A.scrollToFacetValues=function isc_CubeGrid_scrollToFacetValues(_1,_2){if(_2==null)_2=false;var _3=this.getFacetValuesRow(_1),_4=this.getFacetValuesColumn(_1);this.scrollCellIntoView(_3!=-1?_3:null,_4!=-1?_4:null,_2,true)}
,isc.A.scrollToFacetValue=function isc_CubeGrid_scrollToFacetValue(_1,_2){var _3={};_3[_1]=_2;this.scrollToFacetValues(_3)}
,isc.A.getFacetValuesForIndex=function isc_CubeGrid_getFacetValuesForIndex(_1,_2){var _3=_2[_1];if(this.$25c&&_3.childFacetValues!=null){var _4={},_5=this.getRollupValue(this.$25d);if(_5==null)return null;_4[this.$25d]=_5.id;while(true){var _6=_3.facet.id;_4[_6]=_3.facetValueId;if(_3.parent==null)break;_3=_3.parent}
return _4}
if(_3==null){this.logWarn("No such facetValue "+_1+", number of innerHeaders: "+_2.length);return null}
return this.getHeaderFacetValues(_3)}
,isc.A.getHeadersForIndex=function isc_CubeGrid_getHeadersForIndex(_1,_2){var _3=[],_4=(_2?this.innerRowFields[_1]:this.innerColFields[_1]);while(_4!=null){_3.addAt(this.getHeaderForField(_4),0);_4=_4.parent}
return _3}
);isc.evalBoundary;isc.B.push(isc.A.getHeaderFacetValues=function isc_CubeGrid_getHeaderFacetValues(_1){var _2={};while(true){var _3=_1.facet.id;_2[_3]=_1.facetValueId;if(_1.parent==null)break;_1=_1.parent}
return _2}
,isc.A.getSideFacetValues=function isc_CubeGrid_getSideFacetValues(_1,_2){var _3=this.groupByRow?this.rowFacets:this.colFacets,_4={};for(var i=0;i<_3.length;i++){_4[_3[i]]=_1[_3[i]]}
return _4}
,isc.A.getCellFacetValues=function isc_CubeGrid_getCellFacetValues(_1,_2,_3,_4){if((!_4&&(_1+1>this.numRows))||(!_3&&(_2+1>this.numCols))){return null}
var _5;if(!_4&&(this.innerRowFields.length>0)){_5=this.getFacetValuesForIndex(_1,this.innerRowFields)}
if(!_3&&(this.innerColFields.length>0)){var _6=this.getFacetValuesForIndex(_2,this.innerColFields);if(_5!=null){isc.addProperties(_5,_6)}else{_5=_6}}
isc.addProperties(_5,this.fixedFacetValues);return _5}
,isc.A.getFacetValuesColumn=function isc_CubeGrid_getFacetValuesColumn(_1){if(!this.haveColumnFacets())return-1;var _2=[],_3,_4,_5;for(var _6 in _1){var _7=this.columnFacets.indexOf(_6);if(_7<0)continue;var _8=this.getFacet(_6);if(!_8){this.logWarn("Unable to find facet definition for column facet:"+_6);continue}
if(_5==null||_7<_5){_4=_6;_5=_7}}
if(_5<0)return-1;_3=this.colFields[_5];for(var i=_5;i<this.columnFacets.length;i++){_2.add(this.columnFacets[i])}
return this.getFacetValuesOffset(_1,_2,_3,false,true)}
,isc.A.getFacetValuesRow=function isc_CubeGrid_getFacetValuesRow(_1){if(!this.haveRowFacets())return-1;var _2=[],_3,_4,_5;for(var _6 in _1){var _7=this.rowFacets.indexOf(_6);if(_7<0)continue;var _8=this.getFacet(_6);if(!_8){this.logWarn("Unable to find facet definition for row facet:"+_6);continue}
if(_5==null||_7<_5){_4=_6;_5=_7}}
if(_5<0)return-1;_3=this.rowFields[_5];for(var i=_5;i<this.rowFacets.length;i++){_2.add(this.rowFacets[i])}
return this.getFacetValuesOffset(_1,_2,_3,false,true)}
,isc.A.getRowFacetValues=function isc_CubeGrid_getRowFacetValues(_1){return this.getCellFacetValues(_1,null,true)}
,isc.A.getColumnFacetValues=function isc_CubeGrid_getColumnFacetValues(_1){return this.getCellFacetValues(null,_1,null,true)}
,isc.A.getCellRecord=function isc_CubeGrid_getCellRecord(_1,_2,_3){if(_1==null||_1<0||_2<0)return null;if(_2==null)_2=0;if(this.cellIndex==null)this.indexCellRecords();var _4=this.cellIndex[_2]!=null?this.cellIndex[_2][_1]:null;if(_4&&_4.$52r&&!_3)return null;return _4}
,isc.A.setData=function isc_CubeGrid_setData(){this.Super("setData",arguments);this.cellIndex=null;this.$52q=null}
,isc.A.indexCellRecords=function isc_CubeGrid_indexCellRecords(){if(this.$503)return;this.cellIndex=[];var _1=Math.round(5000000/
(this.innerRowFields.length*this.innerColFields.length));if(!this.batchedIndexing||this.data.length<_1){this.addRecordsToIndex(this.data)}else{this.logInfo("Using batchSize: "+_1,"cellIndexing");this.$503=true;var _2=Math.floor(this.data.length/ _1);for(var i=0;i<_2;i++){var _4=(i==_2-1),_5=i*_1;this.$504(_5,_1,_4)}}
if(this.$52q){this.addRecordsToIndex(this.$52q)}}
,isc.A.$504=function isc_CubeGrid__makeIndexingTimer(_1,_2,_3){var _4=this;isc.Timer.setTimeout(function(){_4.addRecordsToIndex(_4.data,_1,_3?_4.data.length:_1+_2);if(_3){_4.$503=null;_4.doneIndexing();_4.body.markForRedraw()}})}
,isc.A.doneIndexing=function isc_CubeGrid_doneIndexing(){}
,isc.A.addRecordsToIndex=function isc_CubeGrid_addRecordsToIndex(_1,_2,_3){_2=_2||0;_3=_3||_1.length;this.logInfo("indexing from "+_2+" through "+_3,"cellIndexing");var _4=isc.timeStamp();if(this.cellIndex==null)this.cellIndex=[];var _5=this.haveColumnFacets(),_6=this.haveRowFacets();if(_5){for(var i=0;i<this.innerColFields.length;i++){var _8=this.innerColFields[i];if(_8==null)continue;_8.coordinate=i}}
if(_6){if(!this.multiRowHeaders||!this.groupByRow){for(var i=0;i<this.innerRowFields.length;i++){var _8=this.innerRowFields[i];if(_8==null)continue;_8.coordinate=i}}else{this.rowFieldMap=[];var _9=0;for(var i=0;i<this.innerRowFields.length;i++){var _8=this.innerRowFields[i];if(_8==null)continue;_8.$76w=i;_8.coordinate=_9;for(var j=_8.coordinate;j<(_8.coordinate+_8.groupCount);j++){this.rowFieldMap[j]=_8}
_9+=_8.groupCount}}}
var _11;if(this.fixedFacetValues)_11=isc.getKeys(this.fixedFacetValues);var _12=this.rowFields[0],_13=this.colFields[0];for(var i=_2;i<_3;i++){var _14=_1[i];if(_11!=null){var _15=true;for(var j=0;j<_11.length;j++){var _16=_11[j];if(_14[_16]!=this.fixedFacetValues[_16]){_15=false;break}}
if(!_15)continue}
var _17=(!_6?0:this.getFacetValuesOffset(_14,this.rowFacets,_12,true)),_18=(!_5?0:this.getFacetValuesOffset(_14,this.columnFacets,_13,true));if(this.cellIndex[_18]==null)this.cellIndex[_18]=[];this.cellIndex[_18][_17]=_14;_14.$24t=_17;_14.$24u=_18;if(this.inlinedFacet&&_17>=0&&_18>=0){this.addInlinedValues(_14,_17,_18)}}
if(this.logIsDebugEnabled("cgTiming")){var _19=(isc.timeStamp()-_4);this.logDebug("indexed cells: "+_19+"ms ("+_1.getLength()+" cellRecords at "+(isc.Browser.isSafari?(_19/ _1.getLength()):(_19/ _1.getLength()).toFixed(2))+"ms per cellRecord)","cgTiming")}}
,isc.A.getCellRow=function isc_CubeGrid_getCellRow(_1){return this.haveRowFacets()?this.getFacetValuesOffset(_1,this.rowFacets,this.rowFields[0],true):-1}
,isc.A.getCellColumn=function isc_CubeGrid_getCellColumn(_1){return this.haveColumnFacets()?this.getFacetValuesOffset(_1,this.columnFacets,this.colFields[0],true):-1}
,isc.A.getCellCoordinates=function isc_CubeGrid_getCellCoordinates(_1){var _2=this.getCellRow(_1),_3=this.getCellColumn(_1);if(_2<0||_3<0)return null;return[_2,_3]}
,isc.A.addInlinedValues=function isc_CubeGrid_addInlinedValues(_1,_2,_3){var _4=this.inlinedFacets!=null,_5=this.rowFacets.contains(this.inlinedFacet.id),_6=_5?this.inlinedFacet:_4?this.inlinedFacets[1]:null,_7=!_5?this.inlinedFacet:_4?this.inlinedFacets[1]:null,_8=_6?_6.values.length:1,_9=_7?_7.values.length:1,_10=this.multiRowHeaders?this.rowFieldMap[_2]:this.innerRowFields[_2],_11=this.innerColFields[_3],_12=(_10?_10.parent:null),_13=(_11?_11.parent:null);var _14,_15;if(_6&&_10.pivotFacetValueId){_14=_1[_10.pivotFacetValueId]}
if(_7&&_11.pivotFacetValueId){_15=_1[_11.pivotFacetValueId]}
if(_14!=null||_15!=null){}
for(var _16=_2;_16<_2+_8;_16++){var _17=this.multiRowHeaders?this.rowFieldMap[_16]:this.innerRowFields[_16];if(_17==null||(_12!=null&&_12!=_17.parent)||(_14!=null&&_17.pivotValue!=_14))break;for(var _18=_3;_18<_3+_9;_18++){var _19=this.innerColFields[_18];if(_19==null||(_13!=null&&_13!=_19.parent)||(_15!=null&&_19.pivotValue!=_15))break;if(this.cellIndex[_18]==null)this.cellIndex[_18]=[];this.cellIndex[_18][_16]=_1}}}
,isc.A.getFacetValuesOffset=function isc_CubeGrid_getFacetValuesOffset(_1,_2,_3,_4,_5){var _6=this.getFacetValuesField(_1,_2,_3,_4,_5);if(!_6)return-1;if(!this.multiRowHeaders)return _6.coordinate;var _7;if(!_5){_7=(_2.last()==this.rowFacets.last())}else{_7=this.rowFacets.contains(_2.last())}
if(_7!=this.groupByRow)return _6.coordinate;return _6.coordinate+(_4?_1[this.groupFacetId]:0)}
,isc.A.getFacetValuesField=function isc_CubeGrid_getFacetValuesField(_1,_2,_3,_4,_5){var _6=_3;var _7;if(this.$25d!=null){_7=this.getRollupValue(this.$25d)}
for(var i=0;i<_2.length;i++){var _9=_2[i],_10=_1[_9],_11=false;if(_5&&_10===_18){if(_6[0].childFacetValues==null)return _6[0];var _12=_2.slice(i+1);for(var j=0;j<_6.length;j++){var _14=_6[j];var _15=this.getFacetValuesField(_1,_12,_14.childFacetValues,false,true);if(_15){return _15}}
return null}
if(this.inlinedFacet&&_4&&this.getFacet(_9).inlinedValues){var _16=_6[0];if(!_16.pivotValue){if(!_16.childFacetValues){return _16}else{_6=_16.childFacetValues;break}}else{var _17=_1[_16.pivotFacetValueId];var _14=_6.find("pivotValue",_17);return _14}}
for(var j=0;j<_6.length;j++){var _14=_6[j];if(_14==null)continue;var _18;if(_14.facetValueId==_10){if(_14.pivotValue){if(_1[_14.facetId]!=_14.pivotFacetValueId)continue}
if(_14.childFacetValues==null)return _14;if(_14.facet.id==this.$25e){if(_7!=null&&_1[this.$25d]==_7.id)
{return _14}}
_11=true;_6=_14.childFacetValues;break}}
if(!_11)return null}
return null}
,isc.A.getValueProperty=function isc_CubeGrid_getValueProperty(_1,_2){if(!this.inlinedFacet)return this.valueProperty;var _3=this.getFacetValueAtCoord(this.inlinedFacet.id,_1,_2);if(!this.inlinedFacets)return _3;var _4=this.getFacetValueAtCoord(this.inlinedFacets[1].id,_1,_2);var _5=this.$502;_5[0]=_3;_5[1]=_4;return _5.join(this.inlinedFacetValueSeparator)}
,isc.A.getCellValue=function isc_CubeGrid_getCellValue(_1,_2,_3){var _4=this.$300(_2,_3)?this.getEditedRecord(_2,_3,true):this.getCellRecord(_2,_3);var _5,_6=(this.$30a&&this.$285==_2&&this.$30u==_3&&this.canEditCell(_2,_3));if(_6){_5=this.getEditItemCellValue(_4,_2,_3)}else{if(_4==null)return this.emptyCellValue;var _7=this.getValueProperty(_2,_3);_5=_4[_7];if(this.haveColumnFacets()){var _8=this.metricFacetId;if(this.getFacet(this.metricFacetId)==null)_8=this.columnFacets.last();var _9=this.getFacetValue(_8,this.innerColFields[_3].facetValueId);if(_9&&_9.getCellValue){isc.Func.replaceWithMethod(_9,"getCellValue","viewer,record,value,rowNum,colNum");_5=_9.getCellValue(this,_4,_2,_3)}}
_5=this.$315(_5,_4,_9,_2,_3)}
var _10;if(this.innerColFields.length>0){_10=this.innerColFields[_3][this.hiliteProperty];if(_10!=null)_5=this.applyHiliteHTML(_10,_5)}
if(this.innerRowFields.length>0){var _11=this.multiRowHeaders?this.rowFieldMap[_2]:this.innerRowFields[_2];_10=_11?[this.hiliteProperty]:null;if(_10!=null)_5=this.applyHiliteHTML(_10,_5)}
if(this.canEdit&&this.showErrorIcons&&this.cellHasErrors(_2,_3)){_5=this.getErrorIconHTML(_2,_3)+_5}
_10=_4[this.hiliteProperty];if(_10!=null)_5=this.applyHiliteHTML(_10,_5);return _5}
,isc.A.getCellStyle=function isc_CubeGrid_getCellStyle(_1,_2,_3){var _4=this.body.getCellStyleIndex(_1,_2,_3);return this.body.getCellStyleName(_4&8)}
,isc.A.getCellCSSText=function isc_CubeGrid_getCellCSSText(_1,_2,_3){var _4=this.getCellRecord(_2,_3),_5,_6,_7,_8=this.body.getCellStyleIndex(_1,_2,_3);if(this.innerColFields.length>0){var _9=this.innerColFields[_3];_6=this.addObjectHilites(_9,_6)}
if(this.innerRowFields.length>0){var _9=this.innerRowFields[_2];_6=this.addObjectHilites(_9,_6)}
if(_4){if(this.inlinedFacet!=null){var _9=this.getCellField(_2,_3);_6=this.getRecordHiliteCSSText(_4,_6,_9)}else{_6=this.addObjectHilites(_4)}}
_8=(_8&~8);if(_8&7){var _10=this.body.getCellStyleName(_8),_7=isc.Element.getStyleText(_10,true);_6=(_6!=null?_6+_7:_7)}
if(this.colBorders[_3]!=null){if(_6==null)_6=this.colBorders[_3];else _6+=this.colBorders[_3]}
if(this.rowBorders[_2]!=null){if(_6==null)_6=this.rowBorders[_2];else _6+=this.rowBorders[_2]}
if(this.canEdit==true){if(this.editFailedBaseStyle==null&&this.editFailedCSSText&&this.cellHasErrors(_2,_3))
{_6+=this.editFailedCSSText}
if(this.editPendingBaseStyle==null&&this.editPendingCSSText&&this.cellHasChanges(_2,_3,false))
{_6+=this.editPendingCSSText}}
return _6}
,isc.A.getBorderStyles=function isc_CubeGrid_getBorderStyles(_1,_2){var _3=[];for(var i=0;i<_1.length;i++){var _5=_1[i];if(_5==null)continue;var _6=this.getBoundaryProperty(_5,"bodyBorder");if(_6){if(!_6.endsWith(isc.semi))_6+=isc.semi;if(!_6.startsWith("border")){_6=(_2?"border-bottom:":"border-right:")+_6}
_3[i]=_6}
if(_5.$25r){_6="border-"+(_2?"top":"left")+":"+_5.$25r+isc.semi;if(_3[i])_3[i]+=_6;else _3[i]=_6}
if(_5.$25s){_6="border-"+(_2?"bottom":"right")+":"+_5.$25s+isc.semi;if(_3[i])_3[i]+=_6;else _3[i]=_6}}
return _3}
,isc.A.bodyDrawing=function isc_CubeGrid_bodyDrawing(){if(this.autoSizeHeaders&&this.haveRowFacets()&&this.rowHeights==null)
{if(this.cellIndex==null)this.indexCellRecords();return"&nbsp;"}
if(this.dataSource&&this.autoFetchData)this.getData()}
,isc.A.getCoordFacetValue=function isc_CubeGrid_getCoordFacetValue(_1,_2){var _3=(_2?this.innerRowFields:this.innerColFields),_4=_3[_1],_5=_4.facetValueId;if(this.$25c&&_4.facet.id==this.$25e){var _6=this.getRollupValue(this.$25d);if(_6==null)return null;return _6.id}
return _5}
,isc.A.getFacetValueAtCoord=function isc_CubeGrid_getFacetValueAtCoord(_1,_2,_3){var _4=this.rowFacets.contains(_1),_5=!_4?this.innerColFields:(this.multiRowHeaders?this.rowFieldMap:this.innerRowFields),_6=_4?_5[_2]:_5[_3];while(_6.facet.id!=_1){_6=_6.parent}
return _6.facetValueId}
,isc.A.addCellToQuery=function isc_CubeGrid_addCellToQuery(_1,_2){var _3=this.getCoordFacetValue(_1,true),_4=this.getCoordFacetValue(_2);var _5=this.getFacetValueGroupId(_1,true),_6=this.getFacetValueGroupId(_2);if(!_5.$25v){_5.$25v={};this.rowGroups.add(_5)}
if(!_6.$25w){if(_6==this.getFacet(_6.id)){_6.$25w=_6.id}else{_6.$25w=this.getFacetPath(_6)}}
var _7=_5.$25v[_6.$25w];var _8=true;if(_7==null){_7=this.makeRegionQuery(_1,_2);_5.$25v[_6.$25w]=_7;this.queries.add(_7);_8=false}
var _9=this.innerRowFields[_1];if(this.$25c&&_9.facet.id==this.$25e){var _10=this.$25e,_11=_9.facetValueId;if(_7.$25x==null){_7.$25x={};_7[_10]=[]}
if(_7.$25x[_11]==null){_7[_10].add(_11);_7.$25x[_11]=isc.emptyString}}
var _12=_7.$25y;if(_12[_3]==null){_7[this.rowFacets.last()].add(_3);_12[_3]=isc.emptyString}
var _13=_7.$25z;if(_13[_4]==null){_7[this.columnFacets.last()].add(_4);_13[_4]=isc.emptyString}}
,isc.A.getFacetValueGroupId=function isc_CubeGrid_getFacetValueGroupId(_1,_2){var _3=(_2?this.innerRowFields:this.innerColFields),_4=_3[_1];return(_4.parent?_4.parent:_4.facet)}
,isc.A.makeRegionQuery=function isc_CubeGrid_makeRegionQuery(_1,_2){var _3=isc.addProperties({},this.fixedFacetValues,this.getGroupFacetValues(_1,true),this.getGroupFacetValues(_2));_3[this.rowFacets.last()]=[];_3[this.columnFacets.last()]=[];_3.$25y={};_3.$25z={};return _3}
,isc.A.getGroupFacetValues=function isc_CubeGrid_getGroupFacetValues(_1,_2){var _3=(_2?this.innerRowFields:this.innerColFields),_4=_3[_1];if(this.$25c&&_4.facet.id==this.$25e){return this.getHeaderFacetValues(_4)}
return(_4.parent?this.getHeaderFacetValues(_4.parent):{})}
,isc.A.combineAllQueries=function isc_CubeGrid_combineAllQueries(){var _1=this.columnFacets;if(_1.length<2)return;var _2=this.rowGroups;for(var i=0;i<_2.length;i++){var _4=_2[i];this.combineRowGroupQueries(isc.getValues(_4.$25v))}}
,isc.A.combineRowGroupQueries=function isc_CubeGrid_combineRowGroupQueries(_1){var _2=[];for(var i=0;i<_1.length;i++){var _4=_1[i];for(var j=0;j<_1.length;j++){var _6=_1[j];if(i==j)continue;if(_2.contains(_4)||_2.contains(_6))continue;if(this.combineQueries(_6,_4)){_2.add(_4);this.queries.remove(_4);break}}}}
,isc.A.combineQueries=function isc_CubeGrid_combineQueries(_1,_2){var _3=this.columnFacets,_4=_3.last(),_5=_3[_3.length-2],_6=_3.slice(0,_3.length-2);var _7=_1[_4];if(this.requestAllFacetValuesImplicitly){if(_7!=null&&_7.length==this.getFacet(_4).values.length)
{delete _1[_4];_7=null}}
for(var j=0;j<_6.length;j++){var _9=_6[j];if(_1[_9]!=_2[_9]){return false}}
var _10=false,_11=_2[_4];if(_7==null&&_11==null){_10=true}else{if(_7!=null&&_11!=null&&_7.length==_11.length&&_7.intersect(_11).length==_7.length)
{_10=true}}
if(_10){var _12=_2[_5],_13=_1[_5];if(!isc.isAn.Array(_13))_13=[_13];if(isc.isAn.Array(_12))_13.addList(_12);else _13.add(_12);_1[_5]=_13;return true}else{return false}}
,isc.A.getData=function isc_CubeGrid_getData(_1,_2){var _3=this.body,_4=_3.getDrawArea();var _5=_4[0],_6=_4[1],_7=_4[2],_8=_4[3];if(this.cellIndex==null)this.indexCellRecords();this.queries=[];this.rowGroups=[];var _9=0;for(var _10=_5;_10<=_6;_10++){for(var _11=_7;_11<=_8;_11++){if(this.getCellRecord(_10,_11,true)==null){var _12=this.getCoordFacetValue(_10,true),_13=this.getCoordFacetValue(_11);if(_12==null||_13==null)continue;_9++;if(!_1&&this.body.$250&&this.fetchDelay>0){if(this.fetchTimeout){isc.Timer.clear(this.fetchTimeout);this.fetchTimeout=null}
this.fetchTimeout=this.delayCall("getData",[true],this.fetchDelay);return}
this.addCellToQuery(_10,_11);if(this.cellIndex[_11]==null)this.cellIndex[_11]=[];this.cellIndex[_11][_10]=Array.LOADING}}}
if(_9==0)return;var _14=this.queries.length;this.combineAllQueries();this.rowGroups.setProperty("$25v",null);var _15=isc.addProperties({},this.lodContext);_15.$251=_4;_15.$256=_9;_15.$257=this.data.getLength();var _16={target:this,methodName:"$54c"};var _17=this.queries.length;isc.rpc.startQueue();for(var i=0;i<_17;i++){var _19=this.queries[i];delete _19.$25y;delete _19.$25z;delete _19.$25x;this.getDataSource().fetchData(_19,i<_17-1?{target:this,methodName:"$258"}:_16,_15)}
isc.rpc.sendQueue()}
,isc.A.bindToDataSource=function isc_CubeGrid_bindToDataSource(_1){return _1}
,isc.A.fetchData=function isc_CubeGrid_fetchData(){}
,isc.A.filterData=function isc_CubeGrid_filterData(){}
,isc.A.setCriteria=function isc_CubeGrid_setCriteria(_1,_2,_3){this.criteria=_1;if(!this.originalData)this.originalData=this.data;var _4=this.originalData;if(this.data&&this.dataSource){this.data=this.getDataSource().applyFilter(_4,this.criteria)}
this.deriveFacetValues(true);this.setFacets();this.setRows();this.setColumns()}
,isc.A.getCriteria=function isc_CubeGrid_getCriteria(){return this.criteria}
,isc.A.$258=function isc_CubeGrid__fetchDataReply(_1,_2,_3){var _4=_1.data;this.data.addList(_4);this.addRecordsToIndex(_4)}
,isc.A.$54c=function isc_CubeGrid__lastFetchDataReply(_1,_2,_3){this.$258(_1,_2,_3);if(this.useFillerCells){var _4=_3.$251,_5=_4[0],_6=_4[1],_7=_4[2],_8=_4[3];var _9=[];for(var _10=_5;_10<=_6;_10++){for(var _11=_7;_11<=_8;_11++){if(Array.isLoading(this.getCellRecord(_10,_11))){var _12=this.getCellFacetValues(_10,_11);_12.$52r=true;_9.add(_12);this.cellIndex[_11][_10]=_12}}}
if(!this.$52q)this.$52q=[];this.$52q.addList(_9)}
this.$25a("dataChanged")}
,isc.A.getOuterSpannedValues=function isc_CubeGrid_getOuterSpannedValues(_1,_2,_3){var _4=(_3?this.rowFields.first():this.colFields.first()),_5=this.getOuterField(_1,_3),_6=this.getOuterField(_2,_3),_7=_4.indexOf(_5),_8=_4.indexOf(_6),_9=[];for(var i=_7;i<=_8;i++){_9.add(_4[i].id)}
return _9}
,isc.A.getOuterField=function isc_CubeGrid_getOuterField(_1,_2){var _3=(_2?this.innerRowFields:this.innerColFields),_4=_3[_1];while(_4.parent)_4=_4.parent;return _4}
,isc.A.$25g=function isc_CubeGrid__setupRowAttributeLOD(){var _1=this.totalAttributeRows;for(var i=0;i<this.rowFields.length;i++){this.rowFields[i].length=_1}
if(this.$24r)return;var _3=this.$24r=isc.ResultSet.create({context:this.lodContext,dataSource:this.rowAttributeDataSource,dataArrived:this.getID()+".$259(startRow,endRow)"});var _4=this.getFacet(this.rowFacets[0]).values.length,_5=[];for(var i=0;i<_4;i++){var _6={};for(var j=0;j<this.rowFacets.length;j++){var _8=this.rowFacets[j],_9=this.getFacet(_8),_10=_9.values[i];_6[_8]=_10}
_5[i]=_6}
_3.fillCacheData(_5);_3.setFullLength(_1)}
,isc.A.$259=function isc_CubeGrid__rowAttributesArrived(_1,_2){var _3=this.$24r.getRange(_1,_2+1),_4=[];for(var i=0;i<_3.length;i++){var _6=_3[i],_7=_1+i;for(var _8 in _6){var _9=this.getFacet(_8);if(_9==null)continue;var _10=_6[_8];_9.values[_7]=_10}
if(_6.cellRecords){var _11=_6.cellRecords;_4.addList(_11)}}
this.data.addList(_4);this.$248(_4);this.setFacets();this.logWarn("rowAttributesLOD: "+(_2-_1+1)+" new rows, "+_4.length+" new cellRecords");this.$249();this.addRecordsToIndex(_4);this.headerGrid.markForRedraw();this.body.markForRedraw();if(this.body.isDirty())this.headerGrid.priorityRedraw=true}
,isc.A.syncHeaderScrolling=function isc_CubeGrid_syncHeaderScrolling(_1,_2){if(this.attributesOnly())return;_1=_1!=null?_1:this.body.getScrollLeft();_2=_2!=null?_2:this.body.getScrollTop();for(var i=0;i<this.colHeaders.length;i++){var _4=this.colHeaders[i];if(_1!=_4.getScrollLeft())_4.scrollTo(_1)}
if(this.rowHeaderGridMode){if(this.headerGrid!=null&&_2!=this.headerGrid.getScrollTop()){if(this.body.isDirty())this.headerGrid.priorityRedraw=true;this.headerGrid.scrollTo(null,_2)}}else{for(var i=0;i<this.rowHeaders.length;i++){var _4=this.rowHeaders[i];if(_2!=_4.getScrollTop())_4.scrollTo(null,_2)}}}
,isc.A.syncBodyScrolling=function isc_CubeGrid_syncBodyScrolling(_1,_2){if(_2==null)_2=false;var _3=(_2?this.rowHeaders:this.colHeaders);if(_1==null)_1=_3.length-1;if(_1>=0){var _4=_3[_1],_5=_4.getScrollLeft(),_6=_4.getScrollTop(),_7=this.body;if(_2){if(_7.getScrollTop()!=_6){_7.scrollTo(null,_6)}}else{if(_7.getScrollLeft()!=_5)_7.scrollTo(_5)}
if(this.attributesOnly()&&_2){var _8=this.rowFacetLabels;if(_8.getScrollLeft()!=_5)_8.scrollTo(_5)}}}
,isc.A.sizeParentFields=function isc_CubeGrid_sizeParentFields(_1,_2,_3,_4){if(_2==this.rowHeaders&&this.rowHeaderGridMode)return;var _5=isc.timeStamp();var _6=_1.last();for(var i=0;i<_6.length;i++){var _8=_6[i];if(_8==null)continue;var _9=_8[_3];if(_9==null||_9=="*"){_8[_3]=_4}}
for(var j=_1.length-1;j>=0;j--){var _11=_1[j];for(var i=0;i<_11.length;i++){var _8=_11[i];if(_8.childFacetValues!=null){_8[_3]=_8.childFacetValues.getProperty(_3).sum();if(_2!=null&&_2[0]!=null&&_2[0].isDrawn()&&!(_2==this.rowHeaders&&this.autoSizeHeaders)){var _12=_2[j].getButton(i);if(_8[_3]!=_12[_3]){_2[j].resizeItem(i,_8[_3]);_12.redrawIfDirty("sizeParentFields")}}}}}
if(this.logIsDebugEnabled("cgTiming")){var _13=isc.timeStamp();this.logInfo("sizeParentFields ("+(_1==this.rowFields?"rows":"cols")+") "+(_13-_5)+"ms","cgTiming")}}
,isc.A.attributesOnly=function isc_CubeGrid_attributesOnly(){return this.dataSource==null&&(this.data==null||this.data.length==0)}
,isc.A.flatAttributesOnly=function isc_CubeGrid_flatAttributesOnly(){return this.attributesOnly()&&this.flatRowAttributes}
,isc.A.createChildren=function isc_CubeGrid_createChildren(){if(this.body!=null)return;var _1=isc.timeStamp();this.createRowHeaderBars();this.createColumnHeaderBars();this.createRowFacetLabels();this.createColumnFacetLabels();if(this.attributesOnly()){this.bodyWidth=0;this.bodyHeight=0}
this.headerHeight=0;this.Super("createChildren",arguments);if(this.attributesOnly()){var _2=isc.Canvas.NO_OP,_3=this.body;_3.draw=_3.redraw=_3.refreshCellStyles=_2}
var _4=isc.timeStamp();if(this.logIsDebugEnabled("cgTiming")){this.logWarn("createChildren(): "+(_4-_1)+"ms","cgTiming")}}
,isc.A.setFields=function isc_CubeGrid_setFields(_1,_2){var _3=(_1!=null||this.completeFields==null);this.Super("setFields",arguments);this.innerColFields=this.fields}
,isc.A.getFieldWidths=function isc_CubeGrid_getFieldWidths(){var _1=this.haveColumnFacets()?this.innerColFields.getProperty("width"):[this.defaultFacetWidth];return _1}
,isc.A.setBodyFieldWidths=function isc_CubeGrid_setBodyFieldWidths(_1){this.Super("setBodyFieldWidths",[_1]);if(this.haveColumnFacets()){this.sizeParentFields(this.colFields,this.colHeaders,"width",this.defaultFacetWidth)}
this.layoutChildren()}
,isc.A.layoutChildren=function isc_CubeGrid_layoutChildren(){if(!this.body)return;var _1=isc.timeStamp();if(this.haveRowFacets()){this.sizeParentFields(this.rowFields,this.rowHeaders,"height",this.facetHeight);this.rowFacetWidths=this.getRowFacetWidths()}
if(!this.$26a){if(this.haveColumnFacets()){this.sizeParentFields(this.colFields,this.colHeaders,"width",this.defaultFacetWidth)}
var _2=this.getFieldWidths();this.setBodyFieldWidths(_2)}
var _3=this.innerHeaderControlSize+2;var _4=this.innerHeaderHeight||this.facetHeight+_3;if(this.haveColumnFacets()){if(this.header.isDrawn()){_4=this.header.getVisibleHeight()}else{var _5=this.getFacet(this.columnFacets.last());if(_5.height)_4=Math.max(_4,_5.height)}}else{var _6=this.rowFacetLabels;if(_6&&_6.isDrawn()){_4=_6.getVisibleHeight()}}
var _7=isc.Element.$yn(this.rowHeaderBarStyleName);if(this.haveRowFacets()){this.bodyOffsetX=this.rowFacetWidths.sum()+_7}else{this.bodyOffsetX=(this.haveColumnFacets()&&this.colFields.length>=2?this.defaultFacetWidth:0)}
if(this.haveColumnFacets()){this.bodyOffsetY=this.colHeaders.map("getVisibleHeight").sum()}else{this.bodyOffsetY=_4}
var _8=this.haveColumnFacets()?this.innerColFields.getProperty("width").sum():this.defaultFacetWidth;var _9=this.cellHeight;if(this.haveRowFacets()){if(this.rowHeaders!=null&&this.rowHeaders[0]!=null&&this.rowHeaders[0].isDrawn())
{if(this.rowHeaderGridMode&&!isc.Browser.isIE){_9=this.headerGrid.$26b().sum()}else{_9=this.rowHeaders.last().getScrollHeight()}}else{if(this.$25c){_9=this.$25f.getOpenList().length*this.cellHeight}else{if(this.rowHeaderGridMode){_9=this.innerRowFields.length*this.cellHeight}else{_9=this.innerRowFields.getProperty("height").sum()}}}}
var _10=this.getScrollbarSize(),_11=this.body.getVBorderSize()||isc.Element.$ym(this.rowHeaderBarStyleName),_12=this.body.getHBorderSize(),_13=Math.max(this.getHeight()-this.bodyOffsetY,this.bodyMinHeight)-_11,_14=Math.max(this.getWidth()-this.bodyOffsetX,this.bodyMinWidth)-_12;var _15=_9>_13,_16=(_15?_10:0),_17=_8>_14,_18=(_17?_10:0);_15=(_9+_18)>_13;_17=(_8+_16)>_14;_16=(_15?_10:0);_18=(_17?_10:0);this.bodyWidth=Math.min(this.getWidth()-this.bodyOffsetX,_8+_12+_16);if(this.bodyMinWidth!=null){this.bodyWidth=Math.min(Math.max(this.bodyWidth,this.bodyMinWidth),_8+_12+_16)}
this.bodyHeight=Math.min(this.getHeight()-this.bodyOffsetY,_9+_11+_18);if(this.bodyMinHeight!=null){this.bodyHeight=Math.min(Math.max(this.bodyHeight,this.bodyMinHeight),_9+_11+_18)}
var _19=(this.attributesOnly()?0:this.bodyWidth);var _20;if(this.bodyMinHeight!=null){_20=this.bodyOffsetY+this.bodyHeight}else{_20=Math.min(this.getHeight(),this.bodyOffsetY+this.bodyHeight)}
if(this.haveRowFacets()){var _21=this.rowFacetWidths.sum()+_7;if(this.attributesOnly()){_21=Math.min(_21,this.getWidth()-_19)}
if(this.rowHeaderGridMode){var _22=_21+(_15&&this.attributesOnly()?this.getScrollbarSize():0);this.headerGrid.setRect(0,this.bodyOffsetY,_22,this.bodyHeight-_18)}else{for(var i=0;i<this.rowFields.length;i++){var _24=this.rowHeaders[i];_24.setRect(this.rowFacetWidths.slice(0,i).sum(),this.bodyOffsetY,this.rowFacetWidths[i],this.bodyHeight-_18)}}
this.rowFacetLabels.setRect(0,this.bodyOffsetY-_4,_21,_4)}
if(this.haveColumnFacets()){var _25=0;for(var i=0;i<this.columnFacets.length;i++){var _5=this.getFacet(this.columnFacets[i]),_24=this.colHeaders[i],_26=(i==this.colFields.length-1),_27=(_26?_4:(_5.height!=null?_5.height:this.facetHeight));_24.setRect(this.bodyOffsetX,_25,this.bodyWidth-_16,_27);if(!_26&&this.columnFacets.length>1&&this.colFacetLabels!=null){_25+=_27;if(this.colFacetLabels.isDrawn()){this.colFacetLabels.getMember(i).setHeight(_27)}else{this.colFacetLabels.buttons[i].height=_27}}}
if(this.colFacetLabels!=null){var _28=this.haveRowFacets()?this.rowFacetWidths.last():this.defaultFacetWidth;this.colFacetLabels.setRect(this.bodyOffsetX-_28,0,_28,_25)}}
if(!this.attributesOnly()){this.body.setRect(this.bodyOffsetX,this.bodyOffsetY,this.bodyWidth,this.bodyHeight)}
var _29;if(this.bodyMinWidth!=null){_29=this.bodyOffsetX+_19}else{_29=Math.min(this.getWidth(),this.bodyOffsetX+_19)}
this.drawnWidth=_29;this.drawnHeight=_20;if(!this.isDrawn()){this.$5y()}else{this.$q5(this.left,this.top,this.drawnWidth,this.drawnHeight);this.$5y()}
if(this.logIsDebugEnabled("cgLayout")){var _30=isc.timeStamp();this.logDebug("CubeGrid layout:\n"+"\nbodyWidth/Height: "+[this.bodyWidth,this.bodyHeight]+"\nbodyScrollWidth/Height: "+[_8,_9]+"\nbodyOffsetX/Y: "+[this.bodyOffsetX,this.bodyOffsetY]+"\nneedH/VScroll: "+[_17,_15]+"\nspecified width/height: "+[this.getWidth(),this.getHeight()]+"\ndrawn width/height: "+[this.drawnWidth,this.drawnHeight]+"\ntime: "+(_30-_1)+"ms","cgLayout")}}
,isc.A.getInitialWidth=function isc_CubeGrid_getInitialWidth(){return this.drawnWidth}
,isc.A.getInitialHeight=function isc_CubeGrid_getInitialHeight(){return this.drawnHeight}
,isc.A.getVisibleHeight=function isc_CubeGrid_getVisibleHeight(){return this.drawnHeight||this.getHeight()}
,isc.A.getVisibleWidth=function isc_CubeGrid_getVisibleWidth(){return this.drawnWidth||this.getWidth()}
,isc.A.getRowFacetWidths=function isc_CubeGrid_getRowFacetWidths(){if(this.rowFacetLabels!=null&&this.rowFacetLabels.isDrawn()){this.rowFacetWidths=this.rowFacetLabels.members.map("getVisibleWidth")}else{this.rowFacetWidths=[];for(var i=0;i<this.rowFacets.length;i++){var _2=Math.max(this.getFacet(this.rowFacets[i]).width,this.rowFields[i].getProperty("width").max());if(!isc.isA.Number(_2)||_2<=0)_2=100;this.rowFacetWidths[i]=_2}}
if(this.$25c)this.rowFacetWidths.length=this.rowFacetWidths.length-1;return this.rowFacetWidths}
,isc.A.makeGridFields=function isc_CubeGrid_makeGridFields(){var _1=[],_2=this.getRowFacetWidths();for(var i=0;i<this.rowFields.length;i++){var _4=this.getFacet(this.rowFacets[i]);if(_4.combineInTree&&i>0){var _5=_1[i-1];_5.$25f=this.$25f;_5.align="left";continue}
_1.add({facetId:_4.id,width:_2[i],align:_4.isTree?"left":(_4.align||this.facetValueAlign)})}
return _1}
,isc.A.createRowHeaderGrid=function isc_CubeGrid_createRowHeaderGrid(_1){var _2=this.headerGrid;if(_2)return;var _3=[];for(var i=0;i<this.numRows;i++)_3[i]={};this.rowGridSelection=isc.CellSelection.create({data:_3,simpleDeselect:this.simpleDeselect,dragSelection:true,numCols:this.rowFacets.length,cubeGrid:this,cellIsSelected:function(_9,_10){var _5=this.cubeGrid.headerGrid,_6=_5.getCellStartRow(_9,_10),_7=_5.getCellRowSpan(_9,_10);for(_9=_6;_9<(_6+_7);_9++){if(this.$26c(_9,_10))return true}
return false},$26c:isc.CellSelection.getInstanceProperty("cellIsSelected")});var _8=this.makeGridFields();var _2=isc.HeaderGrid.create({autoDraw:false,ID:this.getID()+"_headerGrid",cellHeight:this.cellHeight,cellPadding:this.cellPadding,className:this.rowHeaderBarStyleName,baseStyle:this.rowHeaderBaseStyle,totalRows:this.innerRowFields.length,fields:_8,$26a:this.getRowFacetWidths(),overflow:this.attributesOnly()?"auto":"hidden",wrapCells:this.wrapFacetValueTitles,fixedRowHeights:!this.autoSizeHeaders,virtualScrolling:false,drawAheadRatio:this.drawAheadRatio,drawAllMaxCells:0,avgRowHeight:(this.avgRowHeight?this.avgRowHeight:this.cellHeight),cubeGrid:this,alternateRowStyles:this.alternateRowHeaderStyles,selection:(this.canSelectHeaders?this.rowGridSelection:null),selectionBoundaries:this.rowBoundaries,dragMove:this.bodyDefaults.dragMove});this.headerGrid=_2;for(var i=0;i<this.rowFields.length;i++){this.rowHeaders[i]=_2}
this.observe(_2,"cellSelectionChanged","observer.headerSelected(observed)");this.observe(_2,"scrollTo","observer.syncBodyScrolling(0, true)");if(!_1)this.addChild(_2)}
,isc.A.createRowHeaderBars=function isc_CubeGrid_createRowHeaderBars(_1){if(!this.haveRowFacets())return;if(this.rowHeaderGridMode)return this.createRowHeaderGrid(_1);for(var i=0;i<this.rowFields.length;i++){var _3=this.rowFields[i][0].facet,_4=(i==this.rowFields.length-1);var _5=this.createHeader({ID:this.getID()+"_row_header_"+i,_constructor:"ReportHeaderBar",grid:this,cubeGrid:this,facetId:_3.id,vertical:true,buttons:this.rowFields[i].duplicate(),className:this.rowHeaderBarStyleName,selectionBoundaries:this.rowBoundaries,canResizeItems:(_4&&this.canResizeRows),itemDragResized:(_4&&this.canResizeRows)?new Function("itemNum,newSize","this.cubeGrid.rowResized(itemNum,newSize)"):null,canReorderItems:false,dontObserve:true,headerLevel:i,isInnerMost:_4});isc.addProperties(_5.buttonProperties,{baseStyle:this.rowHeaderBaseStyle,skinImgDir:this.skinImgDir,wrap:this.wrapFacetValueTitles,cubeGrid:this,toolbar:_5,overflow:this.autoSizeHeaders?"visible":"hidden",reliableMinHeight:true,height:this.facetHeight});this.rowHeaders[i]=_5;if(!_1)this.addChild(_5);this.observeHeaderBar(_5,i,true)}}
,isc.A.createColumnHeaderBars=function isc_CubeGrid_createColumnHeaderBars(_1){if(!this.haveColumnFacets())return;for(var i=0;i<this.colFields.length;i++){var _3=this.colHeaders[i];var _4=this.colFields[i][0].facet;var _5=(i==this.colFields.length-1);if(_3==null){var _4=this.getFacet(this.columnFacets[i]);var _3={ID:this.getID()+"_col_header_"+i,_constructor:"ReportHeaderBar",grid:this,cubeGrid:this,facetId:_4.id,buttons:this.colFields[i].duplicate(),height:(_4.height!=null?_4.height:this.facetHeight),selectionBoundaries:this.colBoundaries,canResizeItems:(_5&&this.canResizeFields),canReorderItems:(_5&&this.canReorderFields),canAcceptDrop:(_5&&this.canMoveFacets),dontObserve:!_5,reorderOnDrop:false,headerLevel:i,isInnerMost:_5}
if(_5)_3.buttonConstructor="InnerHeader";_3=this.createHeader(_3);isc.addProperties(_3.buttonProperties,{baseStyle:_5?this.innerHeaderBaseStyle:this.colHeaderBaseStyle,skinImgDir:this.skinImgDir,wrap:this.wrapFacetValueTitles,cubeGrid:this,toolbar:_3,height:this.facetHeight,showReorderHandle:this.canReorderFields,showMinimize:this.canMinimizeColumns,controlSize:this.innerHeaderControlSize,reorderHandleWidth:this.innerHeaderReorderHandleWidth,minWidth:(3*this.innerHeaderControlSize)});this.colHeaders[i]=_3;if(!_1)this.addChild(_3);this.observeHeaderBar(_3,i,false)}}
this.header=this.colHeaders.last()}
,isc.A.$51c=function isc_CubeGrid__refreshMasterIndexForFields(_1){for(var i=0;i<_1.length;i++){var _3=_1[i];if(this.fields.contains(_3))_3.masterIndex=this.fields.indexOf(_3);else{_3.masterIndex=this.fields.findIndex("id",_3.facetValueId)}}}
,isc.A.createRowFacetLabels=function isc_CubeGrid_createRowFacetLabels(){if(!this.haveRowFacets())return;var _1=[],_2=this.getRowFacetWidths();for(var i=0;i<this.rowFields.length;i++){var _4=this.getFacet(this.rowFacets[i]);var _5={title:_4.title,align:_4.titleAlign||this.facetTitleAlign,facet:_4,facetId:_4.id,showCloseBox:(_4.canClose!=null?_4.canClose:this.canCloseColumns),showSortButtons:(_4.canSort!=null?_4.canSort:this.canSortFacets),width:_2[i],baseStyle:_4.rowLabelStyle||_4.labelStyle||this.rowHeaderLabelBaseStyle,skinImgDir:this.skinImgDir};_1.add(_5)}
this.rowFacetLabels=isc.ReportHeaderBar.create({ID:this.getID()+"_rowFacetLabels",tabIndex:(this.canTabToHeader?this.getTabIndex():-1),className:this.rowFacetLabelsStyleName,buttonConstructor:"InnerHeader",buttons:_1,canResizeItems:true,canReorderItems:this.canReorderFacets,showIf:(this.showRowFacetLabels==false?"false":null),setResizeRules:function(){this.Super("setResizeRules",arguments);for(var i=0;i<this.members.length;i++){var _6=this.members[i];_6.resizeFrom.add("B");_6.edgeCursorMap["B"]=isc.Canvas.ROW_RESIZE}},prepareForDragging:function(){this.Super("prepareForDragging",arguments);var _7=isc.EH;if(_7.dragOperation=="dragResize"&&"B"==_7.resizeEdge){_7.dragTarget.dragAppearance=_7.OUTLINE}},dragResizeStop:function(){var _8=this.Super("dragResizeStop",arguments);var _7=isc.EH,_9=_7.dragTarget;if(_7.dragOperation=="dragResize"&&"B"==_7.resizeEdge){_9.dragAppearance=_7.NONE;this.cubeGrid.rowFacetBarResized(_9,_7.dragResizeHeight);return false}
return _8}},this.getFacetBarProperties());isc.addProperties(this.rowFacetLabels.buttonProperties,{toolbar:this.rowFacetLabels},this.getFacetLabelProperties());this.addChild(this.rowFacetLabels);this.observe(this.rowFacetLabels,"itemDragResized","observer.rowFacetResized(itemNum, newSize)");this.observe(this.rowFacetLabels,"itemDragReordered","observer.rowFacetReordered(itemNum, newPosition)");this.observeHeaderBar(this.rowFacetLabels,null,true)}
,isc.A.createColumnFacetLabels=function isc_CubeGrid_createColumnFacetLabels(){if(!this.haveColumnFacets()||this.columnFacets.length<2)return;var _1=[];for(var i=0;i<this.colFields.length;i++){var _3=this.colFields[i][0].facet;var _4=(i==this.colFields.length-1);if(_4)continue;var _5={baseStyle:_3.colLabelStyle||_3.labelStyle||this.colHeaderLabelBaseStyle,title:_3.title,align:_3.titleAlign||this.facetTitleAlign,facetId:_3.id};_1.add(_5)}
this.colFacetLabels=isc.ReportHeaderBar.create({ID:this.getID()+"_colFacetLabels",vertical:true,canResizeItems:true,showIf:(this.showColFacetLabels==false?"false":null),tabIndex:(this.canTabToHeader?this.getTabIndex():-1),buttons:_1},this.getFacetBarProperties());isc.addProperties(this.colFacetLabels.buttonProperties,{toolbar:this.colFacetLabels},this.getFacetLabelProperties());this.addChild(this.colFacetLabels);this.observe(this.colFacetLabels,"itemDragResized","observer.columnFacetResized(itemNum, newSize)")}
,isc.A.prepareForDraw=function isc_CubeGrid_prepareForDraw(){this.Super("prepareForDraw",arguments);this.layoutChildren();if(this.hilites)this.applyHilites()}
,isc.A.draw=function isc_CubeGrid_draw(_1){if(!this.readyToDraw())return this;this.Super("draw",arguments);if(this.autoSizeHeaders){if(!isc.Page.isLoaded()){var _2="if(window."+this.getID()+")"+this.getID()+".adjustHeaderHeights()";isc.Page.setEvent("load",_2)}else{if(isc.Browser.isIE){this.delayCall("adjustHeaderHeights",[],0)}else{this.adjustHeaderHeights()}}}}
,isc.A.getCascadedHeight=function isc_CubeGrid_getCascadedHeight(_1){var _2=this.getHeaderForField(_1);var _3=_2.getButtonMinHeight();if(_3<22)_3=22;var _4=_2.newHeight=(_2.newHeight!=null?Math.max(_2.newHeight,_3):_3);if(!_2.childFacetValues){return _2.newHeight}
var _5=this.map("getCascadedHeight",_2.childFacetValues).sum();_2.newHeight=Math.max(_4,_5);var _6=_4-_5;if(_6>0){this.setCascadedHeight(_2,_6)}
return _2.newHeight}
,isc.A.setCascadedHeight=function isc_CubeGrid_setCascadedHeight(_1,_2){var _3=_1.childFacetValues.length,_4=Math.floor(_2/ _3),_5=_4+(_2%_3);for(var i=0;i<_3;i++){var _7=_1.childFacetValues[i],_8=this.getHeaderForField(_7),_9=(i==_3-1?_5:_4);_8.newHeight+=_9;if(_8.childFacetValues)this.setCascadedHeight(_8,_9)}}
);isc.evalBoundary;isc.B.push(isc.A.adjustHeaderHeights=function isc_CubeGrid_adjustHeaderHeights(){if(this.haveRowFacets()){if(this.rowHeaderGridMode){this.rowHeights=this.headerGrid.$26b()}else{var _1=this.rowFields.first();for(var i=0;i<_1.length;i++){this.getCascadedHeight(_1[i])}
for(var i=0;i<this.rowHeaders.length;i++){var _3=this.rowHeaders[i],_4=_3.getButtons();for(var j=0;j<_4.length;j++){var _6=_4[j];_6.setHeight(_6.newHeight);_6.newHeight=null;_6.redrawIfDirty("autoSizing row headers")}
_3.setHeight(_4.map("getHeight").sum())}
var _7=this.rowHeaders.last();this.rowHeights=_7.getButtons().map("getHeight");for(var i=0;i<this.rowHeights.length;i++){this.innerRowFields[i].height=this.rowHeights[i]}}}
this.layoutChildren();if(this.headerGrid&&this.multiCellData)this.headerGrid.markForRedraw();this.$25a("adjustHeaderHeights");this.$5y()}
,isc.A.getRowHeight=function isc_CubeGrid_getRowHeight(_1,_2){if(this.multiRowHeaders){var _3=this.rowFieldMap[_2],_4=_3.groupCount,_5=_3.$76w,_6=this.headerGrid.getRowSize(_5),_7=Math.floor(_6/ _4),_8=((_2-_3.coordinate)==(_4-1));if(_8){_7+=(_6%_4)}
return _7}
var _9;if(this.rowHeaderGridMode){_9=_2-this.body.$252}else{_9=_2}
if(!this.rowHeights||this.rowHeights[_9]==null)return this.cellHeight;return this.rowHeights[_9]}
,isc.A.facetLabelClick=function isc_CubeGrid_facetLabelClick(){}
,isc.A.getFacetLabelProperties=function isc_CubeGrid_getFacetLabelProperties(){return isc.addProperties({showRollOver:false,autoDraw:false,cubeGrid:this,showReorderHandle:this.canReorderFacets&&!this.canMoveFacets,controlSize:this.innerHeaderControlSize,reorderHandleWidth:this.innerHeaderReorderHandleWidth,minWidth:(3*this.innerHeaderControlSize),wrap:this.wrapFacetTitles,padTitle:this.padTitles},this.facetLabelMethods)}
,isc.A.$26d=function isc_CubeGrid__facetBarDrop(){this.cubeGrid.addFacet(isc.EH.dragTarget.facetId,!this.vertical,this.getDropPosition())}
,isc.A.getFacetBarProperties=function isc_CubeGrid_getFacetBarProperties(){return{isFacetBar:true,backgroundColor:this.headerBackgroundColor,cubeGrid:this,autoDraw:false,canRemoveItems:this.canMoveFacets,canAcceptDrop:this.canMoveFacets,drop:this.$26d}}
,isc.A.$26e=function isc_CubeGrid__facetValueHover(_1){if(this.facetValueHover){if(this.facetValueHover(_1)==false)return}
if(this.showHover){var _2=this.getContainingFacet(_1),_3=this.getFacetLocation(_2),_4={width:this.facetValueHoverWidth||this.hoverWidth,height:this.facetValueHoverHeight||this.hoverHeight,align:this.facetValueHoverAlign||this.hoverAlign,valign:this.facetValueHoverVAlign||this.hoverVAlign,baseStyle:this.facetValueHoverStyle||this.hoverStyle,opacity:this.hoverOpacity,moveWithMouse:this.hoverMoveWithMouse};isc.Hover.show(this.facetValueHoverHTML(_1),_4)}}
,isc.A.$26f=function isc_CubeGrid__facetValueOver(_1){if(this.facetValueOver)this.facetValueOver(_1);if(this.canHover){isc.Hover.setAction(this,this.$26e,[_1],this.hoverDelay)}}
,isc.A.$26g=function isc_CubeGrid__facetValueContextClick(_1){this.facetValueContextItems=null;if(this.facetValueContextClick){var _2=this.getHeaderFacetValues(_1);if(this.facetValueContextClick(_2,_1.facet.id,_1)==false)return false}
if(this.showFacetValueContextMenus){if(!this.facetValueContextMenu){this.facetValueContextMenu=isc.Menu.create(this.contextMenuProperties)}
if(!this.facetValueContextItems){this.facetValueContextItems=this.makeFacetValueContextItems(this.getHeaderFacetValues(_1),_1.facet.id,_1)}
if(isc.isAn.Array(this.facetValueContextItems)&&this.facetValueContextItems.length>0){this.facetValueContextMenu.setData(this.facetValueContextItems);this.facetValueContextMenu.showContextMenu(this)}
return false}else{return this.showContextMenu()}}
,isc.A.$24p=function isc_CubeGrid__facetLabelHover(_1){if(this.facetLabelHover){this.convertToMethod("facetLabelHover");if(this.facetLabelHover(_1)==false)return}
if(this.showHover){var _2=this.getHeader(_1);this.convertToMethod("facetLabelHoverHTML");var _3={width:(this.facetLabelHoverWidth||this.hoverWidth),height:(this.facetLabelHoverHeight||this.hoverHeight),align:(this.facetLabelHoverAlign||this.hoverAlign),valign:(this.facetLabelHoverVAlign||this.hoverVAlign),baseStyle:(this.facetLabelHoverStyle||this.hoverStyle),opacity:this.hoverOpacity,moveWithMouse:this.hoverMoveWithMouse};isc.Hover.show(this.facetLabelHoverHTML(_1),_3)}}
,isc.A.facetLabelHoverHTML=function isc_CubeGrid_facetLabelHoverHTML(_1){return null}
,isc.A.facetValueHoverHTML=function isc_CubeGrid_facetValueHoverHTML(_1){return null}
,isc.A.outsetHoverRect=function isc_CubeGrid_outsetHoverRect(_1){return isc.Canvas.outsetRect(_1,this.cellHoverOutset)}
,isc.A.getHeaderSpan=function isc_CubeGrid_getHeaderSpan(_1){var _2=_1;if(isc.isA.Canvas(_2))_2=this.getFieldForHeader(_2);var _3=_2,_4=_2;while(_3.childFacetValues){if(this.$25c&&_3.facet.id==this.$25e){var _5=this.$25f.getOpenList(),_6=_5.indexOf(_3),_7=_5.indexOf(_4);_7+=this.$25f.getOpenList(_4).length-1;return[_6,_7]}else{_3=_3.childFacetValues.first();_4=_4.childFacetValues.last()}}
var _8=_2.isRowHeader?this.innerRowFields:this.innerColFields;return[_8.indexOf(_3),_8.indexOf(_4)]}
,isc.A.getHeaderBarFields=function isc_CubeGrid_getHeaderBarFields(_1){var _2=(_1.vertical?this.rowFields:this.colFields);return _2[_1.headerLevel]}
,isc.A.getFieldForHeader=function isc_CubeGrid_getFieldForHeader(_1){var _2=_1.parentElement,_3=_2.getButtonNumber(_1),_4=this.getHeaderBarFields(_2);return _4[_3]}
,isc.A.getHeaderForField=function isc_CubeGrid_getHeaderForField(_1){if(isc.isA.Canvas(_1))return _1;var _2=_1.isRowHeader?this.rowHeaders:this.colHeaders,_3=_1.isRowHeader?this.rowFields:this.colFields,_4=_2[_1.headerLevel],_5=_3[_1.headerLevel].indexOf(_1);return _4.getButton(_5)}
,isc.A.getFacetLocation=function isc_CubeGrid_getFacetLocation(_1){if(isc.isAn.Object(_1)){for(var _2 in _1){};_1=_2}
if(this.haveRowFacets()){var _3=this.rowFacets.indexOf(_1);if(_3!=-1)return{isRow:true,level:_3}}
if(this.haveColumnFacets()){var _3=this.columnFacets.indexOf(_1);if(_3!=-1)return{isRow:false,level:_3}}
return null}
,isc.A.getHeader=function isc_CubeGrid_getHeader(_1){if(isc.isA.String(_1)){var _2=this.getFacetLocation(_1);if(_2==null)return null;var _3=(_2.isRow?this.rowFacetLabels:this.colFacetLabels);return _3.getButtons().find("facetId",_1)}
var _4=_1,_5=this.getContainingFacet(_4),_3=this.getHeaderBar(_5);if(!_3)return null;var _6=_3.getButtons().findAll("facetValueId",_4[_5]);if(_6==null)return _6;for(var i=0;i<_6.length;i++){var _8=_6[i],_9=this.getHeaderFacetValues(_8),_10=true;for(var _11 in _4){_10=_10&&(_9[_11]==_4[_11])}
if(_10)return _8}
return null}
,isc.A.getHeaderBar=function isc_CubeGrid_getHeaderBar(_1){if(isc.isA.String(_1)){var _2=this.getFacetLocation(_1);if(_2==null)return null;if(_2.isRow)return this.rowHeaders[_2.level];return this.colHeaders[_2.level]}
return this.getHeaderBar(this.getContainingFacet(_1))}
,isc.A.getContainingFacet=function isc_CubeGrid_getContainingFacet(_1){var _2=isc.getKeys(_1),_3=_2[0],_4=this.getFacetLocation(_3).isRow,_5=_2.length;return(_4?this.rowFacets[_5-1]:this.columnFacets[_5-1])}
,isc.A.getHeaderBarFacetValues=function isc_CubeGrid_getHeaderBarFacetValues(_1){var _2=this.getHeaderBar(_1);if(_2==null)return null;return this.getAllFacetValues(_2.getButtons())}
,isc.A.getAllFacetValues=function isc_CubeGrid_getAllFacetValues(_1){var _2=[];for(var i=0;i<_1.length;i++){var _4=_1[i];_2.add(this.getHeaderFacetValues(_4))}
return _2}
,isc.A.getHeaderButtonProperties=function isc_CubeGrid_getHeaderButtonProperties(){var _1=this.Super("getHeaderButtonProperties",arguments);if(this.$26h==null){this.$26h=function(){var _2=this.Super("getTitle"),_3=this.cubeGrid;if(this.$25q!=null){_2=_3.applyHiliteHTML(this.$25q,_2)}
if(_3.shouldShowTurndown(this)){_2=_3.addTurndown(_2,this)}
return _2}}
_1.getTitle=this.$26h;_1.padTitle=this.padTitles;return _1}
,isc.A.shouldShowTurndown=function isc_CubeGrid_shouldShowTurndown(_1){if(_1.canCollapse&&_1.$244&&_1.$244.length>0)return true;if(this.$25c&&_1.facet.id==this.$25e)return true;return(_1.childFacetValues&&_1.canMinimize)}
,isc.A.addTurndown=function isc_CubeGrid_addTurndown(_1,_2){if(!this.$26i){var _3=' onmousedown="return '+this.getID()+'.$26j()" ';this.$26k=this.imgHTML("[SKIN]arrow_closed_down.gif",16,16,null,_3);this.$26l=this.imgHTML("[SKIN]arrow_closed_right.gif",16,16,null,_3);this.$26m=this.imgHTML("[SKIN]arrow_closed_left.gif",16,16,null,_3);this.$26n=this.imgHTML("[SKIN]arrow_open_down.gif",16,16,null,_3);this.$26o=this.imgHTML("[SKIN]arrow_open_up.gif",16,16,null,_3);this.$26p=this.imgHTML("[SKIN]arrow_open_right.gif",16,16,null,_3);this.$26q=this.imgHTML("[SKIN]arrow_open_left.gif",16,16,null,_3);this.$26i=true}
var _4=this.getToggleProperty(_2),_5=!_2[_4],_6;if(!_5){_6=_2.isRowHeader?(this.isRTL()?this.$26m:this.$26l):this.$26k}else{var _7=_2.facet.id,_8=((_2.facet.isTree&&_2.facet.showParentsLast)||(this.inMultiFacetColumn(_7)&&this.getFacet(this.$25e).showParentsLast));if(_2.isRowHeader){_6=_8?this.$26o:this.$26n}else{_6=_8?this.$26q:this.$26p}}
return _6+_1}
,isc.A.getToggleProperty=function isc_CubeGrid_getToggleProperty(_1){return(_1.$244&&_1.$244.length>0?"collapsed":"minimized")}
,isc.A.$26j=function isc_CubeGrid__toggleOpenState(){var _1,_2;if(this.headerGrid&&this.headerGrid.containsEvent()){_2=true;var _3=this.headerGrid,_4=_3.getEventRow(),_5=_3.getEventColumn(),_1=_3.getCellField(_4,_5)}else{var _6=[].concat(this.rowHeaders).concat(this.colHeaders);for(var i=0;i<_6.length;i++){var _8=_6[i];if(_8.containsEvent()){var _9=_8.getMouseOverButtonIndex(),_10=_8.getButton(_9),_11=_10.facet.id,_12=this.getFacetLocation(_11),_13=(_12.isRow?this.rowFields:this.colFields);_2=_12.isRow;_1=_13[_12.level][_9];break}}}
var _14=this.getHeaderFacetValues(_1),_15=this.getFieldProperties(_14),_16=this.getToggleProperty(_1);if(_15!=null){_15[_16]=!_1[_16]}else{this.setFieldProperty(_1,_16,!_1[_16])}
_2?this.setRows(null,true):this.setColumns(null,true);return false}
,isc.A.facetValueDoubleClick=function isc_CubeGrid_facetValueDoubleClick(_1){if(this.haveColumnFacets()){var _2=this.getFacetValuesOffset(_1,this.columnFacets,this.colFields[0]);if(_2==-1)return;this.delayCall("autoSizeBodyColumn",[_2],0)}}
,isc.A.autoSizeBodyColumn=function isc_CubeGrid_autoSizeBodyColumn(_1){var _2=this.header.getButton(_1);this.setMinimized(_2,false);var _3=this.body.getColumnAutoSize(_1),_4=_2.getPreferredWidth();_3=Math.max(_3,_4);this.resizeField(_1,_3)}
,isc.A.facetLabelDoubleClick=function isc_CubeGrid_facetLabelDoubleClick(_1){this.autoSizeFacet(_1.facetId)}
,isc.A.autoSizeFacet=function isc_CubeGrid_autoSizeFacet(_1){var _2=this.getFacetLocation(_1);if(!_2.isRow)return;var _3=this.getHeader(_1),_4=_3.getPreferredWidth();var _5;if(this.rowHeaderGridMode){_5=this.headerGrid.getColumnAutoSize(_2.level)}else{var _6=this.getHeaderBar(_1),_7=_6.getButtons();_5=_7.map("getPreferredWidth").max()}
var _8=Math.max(_5,_4);var _9=this.rowFacetLabels.getButtonNumber(_3);this.rowFacetResized(_9,_8)}
,isc.A.$26r=function isc_CubeGrid__columnIsSorted(_1){var _2=false;if(this.sortedFacetId==_1){return true}
else if(isc.isAn.Object(this.sortedFacetValues)&&isc.isAn.Object(_1)){var _3=this.getHeaderFacetValues(_1);_2=true;for(var _4 in this.sortedFacetValues){if(_3[_4]!=this.sortedFacetValues[_4]){_2=false;break}}}
return _2}
,isc.A.$26s=function isc_CubeGrid__sortButtonClick(_1,_2){if(this.sortDirection==_2&&this.$26r(_1))return false;if(isc.isAn.Object(_1)){if(this.sortByFacetValues){this.convertToMethod("sortByFacetValues");this.sortByFacetValues(this.getHeaderFacetValues(_1),_2)}}else{if(this.sortByFacetId){this.convertToMethod('sortByFacetId');this.sortByFacetId(_1,_2)}}}
,isc.A.headerClick=function isc_CubeGrid_headerClick(_1){return false}
,isc.A.$26t=function isc_CubeGrid__headerCloseClick(_1,_2){if(isc.isAn.Object(_1)){this.closeColumn(this.getHeaderFacetValues(_1))}else{this.closeFacet(_1)}}
,isc.A.closeFacet=function isc_CubeGrid_closeFacet(_1){}
,isc.A.closeColumn=function isc_CubeGrid_closeColumn(_1){}
,isc.A.rebuildField=function isc_CubeGrid_rebuildField(_1){this.getFacetLocation(_1).isRow?this.setRows(null,true):this.setColumns(null,true)}
,isc.A.addFacetValue=function isc_CubeGrid_addFacetValue(_1,_2,_3){this.getFacet(_1).values.add(_2);this.setFacets();if(_3){_2.hidden=true;this.showFacetValues(_3)}else{this.rebuildField(_1)}}
,isc.A.removeFacetValue=function isc_CubeGrid_removeFacetValue(_1,_2){var _3=this.getFacet(_1);_3.values.remove(_3.values.find("id",_2));this.setFacets();this.rebuildField(_1)}
,isc.A.updateFacetValue=function isc_CubeGrid_updateFacetValue(_1,_2){var _3=this.getFacet(_1),_4=_3.values.findIndex("id",_2.id);_3.values[_4]=_2;this.setFacets();this.rebuildField(_1)}
,isc.A.hideFacetValue=function isc_CubeGrid_hideFacetValue(_1,_2,_3){var _4=this.getFacetValue(_1,_2);_4.hidden=true;if(!_3)this.rebuildField(_1)}
,isc.A.showFacetValue=function isc_CubeGrid_showFacetValue(_1,_2,_3){var _4=this.getFacetValue(_1,_2);delete _4.hidden;if(!_3)this.rebuildField(_1)}
,isc.A.hideFacetValues=function isc_CubeGrid_hideFacetValues(_1){this.setFieldProperty(_1,"hidden",true);this.rebuildField(_1)}
,isc.A.showFacetValues=function isc_CubeGrid_showFacetValues(_1){this.setFieldProperty(_1,"hidden",false);this.rebuildField(_1)}
,isc.A.getSyncedHeaders=function isc_CubeGrid_getSyncedHeaders(_1){if(!_1.facetValueGroup)return[_1];var _2=_1.parentElement;return _2.getButtons().findAll({"facetValueId":_1.facetValueId,"facetValueGroup":_1.facetValueGroup})}
,isc.A.setMinimized=function isc_CubeGrid_setMinimized(_1,_2){var _3=this.getSyncedHeaders(_1);var _4=_1.getVisibleWidth();for(var i=0;i<_3.length;i++){var _6=_3[i];_6.minimized=_2;_6.canDragResize=!_2;if(_2)_6.$26u=_4}
_1.parentElement.setResizeRules()}
,isc.A.minimizeColumn=function isc_CubeGrid_minimizeColumn(_1,_2){if(_2==null)_2=true;var _3=this.header.getButton(_1);this.setMinimized(_3,_2);this.resizeField(_1,_2?_3.controlSize:_3.$26u)}
,isc.A.minimizeClick=function isc_CubeGrid_minimizeClick(_1,_2){this.minimizeColumn(_1.parentElement.getButtonNumber(_1),_2)}
,isc.A.observeHeaderBar=function isc_CubeGrid_observeHeaderBar(_1,_2,_3){this.observe(_1,"selectionChanged","observer.headerSelected(observed)");if(_2!=null){this.observe(_1,"scrollTo","observer.syncBodyScrolling("+_2+","+_3+")")}}
,isc.A.deselectHeaders=function isc_CubeGrid_deselectHeaders(_1,_2){for(var i=0;i<_1.length;i++){var _4=_1[i];if(_4!=_2&&_4.selection!=null){_4.selection.deselectAll()}}}
,isc.A.headerSelected=function isc_CubeGrid_headerSelected(_1){this.clearOtherSelections(_1);if(_1.isFacetBar){this.autoSelectFacetValues(_1);return}
if(this.rowHeaderGridMode&&_1.vertical)
{if(this.facetValueSelectionChanged&&this.facetValueSelectionChanged()==false)return false}else{var _2=_1.selection.lastSelectionItem,_3=_1.selection.isSelected(_2);if(this.facetValueSelectionChanged){var _4=this.getHeaderFacetValues(_2);if(this.facetValueSelectionChanged(_4,_3)==false)return false}
if(this.autoSelectHeaders&&!this.autoSelectingHeaders){this.syncHeaderTreeSelection(_1,_2,_3)}}
if(this.autoSelectValues&&this.autoSelectValues!="none"&&_1.isInnerMost){if(this.rowHeaderGridMode&&_1.vertical){var _5=_1.selection.changedCells,_6=this.rowFacets.length-1;for(var i=0;i<_5.length;i++){var _8=_5[i],_9=_8[0],_10=_8[1];if(_10!=_6)continue;var _3=_1.selection.cellIsSelected(_8[0],_8[1]);this.selectSpannedCells([_9,_9],true,_3)}}else{var _3=_1.selection.isSelected(_1.selection.lastSelectionItem);this.selectSpannedCells(this.getHeaderSpan(_2),_1.vertical,_3)}}}
,isc.A.selectSpannedCells=function isc_CubeGrid_selectSpannedCells(_1,_2,_3){if(_2&&(this.autoSelectValues=="both"||this.autoSelectValues=="rows"))
{var _4=this.findSelectionBoundary(0,this.numCols-1,this.colBoundaries);this.selection.setCellRangeSelection(_1[0],0,_1[1],_4,_3)}else if(!_2&&(this.autoSelectValues=="both"||this.autoSelectValues=="cols"))
{var _5=this.findSelectionBoundary(0,this.numRows-1,this.rowBoundaries);this.selection.setCellRangeSelection(0,_1[0],_5,_1[1],_3)}}
,isc.A.clearOtherSelections=function isc_CubeGrid_clearOtherSelections(_1){if(_1!=this.lastSelectionHeaderBar&&!this.autoSelectingHeaders){if(isc.EventHandler.ctrlKeyDown()){if(this.lastSelectionHeaderBar==null)this.selection.deselectAll();this.lastSelectionHeaderBar=_1;var _2=this.getFacetsHavingSelection();if(_2.contains(this.metricFacetId)&&(_2.length>1||_1==this.rowFacetLabels))
{}else{return}}
if(!(this.rowHeaderGridMode&&_1.vertical&&this.lastSelectionHeaderBar&&this.lastSelectionHeaderBar.vertical))
{this.selection.deselectAll()}
this.autoSelectingHeaders=true;if(!(_1.vertical&&this.rowHeaderGridMode)){this.deselectHeaders(this.rowHeaders,_1)}
this.deselectHeaders(this.colHeaders,_1);if(this.showRowFacetLabels!=false&&this.rowFacetLabels&&_1!=this.rowFacetLabels)
{this.rowFacetLabels.selection.deselectAll()}
this.lastSelectionHeaderBar=_1;this.autoSelectingHeaders=false}}
,isc.A.autoSelectFacetValues=function isc_CubeGrid_autoSelectFacetValues(_1){if(this.autoSelectingHeaders)return;this.autoSelectingHeaders=true;var _2=_1.selection.lastSelectionItem,_3=_1.selection.isSelected(_2),_4=this.getHeaderBar(_2.facetId);if(this.rowHeaderGridMode){var _5=this.rowFieldsVisualOrder||this.rowFields;var _6=_5.getProperty("0"),_7=_6.getProperty("facet").getProperty("id"),_8=_7.indexOf(_2.facetId);if(_3)_4.selection.selectCol(_8);else _4.selection.deselectCol(_8)}else{if(_3)_4.selection.selectAll();else _4.selection.deselectAll()}
this.autoSelectingHeaders=false}
,isc.A.syncHeaderTreeSelection=function isc_CubeGrid_syncHeaderTreeSelection(_1,_2,_3){this.autoSelectingHeaders=true;this.autoSelectChildren(_2,_3);var _4=_2;while(_4.parent){_2=this.getHeaderForField(_4);_1=_2.parentElement;var _5=_2.parent.childFacetValues;for(var i=0;i<_5.length;i++){var _7=this.getHeaderForField(_5[i]);if(!_1.selection.isSelected(_7))break}
var _8=(i==_5.length),_9=this.getHeaderForField(_2.parent),_10=_9.parentElement;if(_10.selection.isSelected(_9)!=_8){_10.selection.setSelected(_9,_8)}
_4=_4.parent}
this.autoSelectingHeaders=false}
,isc.A.autoSelectChildren=function isc_CubeGrid_autoSelectChildren(_1,_2){if(_1.childFacetValues==null||_1.childFacetValues.length==0)return;var _3=_1.childFacetValues;for(var i=0;i<_3.length;i++){var _5=this.getHeaderForField(_3[i]),_6=_5.parentElement;if(_2!=_6.selection.isSelected(_5)){_6.selection.setSelected(_5,_2);this.autoSelectChildren(_5,_2)}}}
,isc.A.getSelectedCells=function isc_CubeGrid_getSelectedCells(){return this.getSelection()}
,isc.A.getSelectedCellIds=function isc_CubeGrid_getSelectedCellIds(){return this.getSelection().getProperty(this.cellIdProperty)}
,isc.A.anyCellSelected=function isc_CubeGrid_anyCellSelected(){return this.selection.anySelected()}
,isc.A.cellIsSelected=function isc_CubeGrid_cellIsSelected(_1){if(_1!=null&&_1.$24t==null)_1=this.data.find(this.cellIdProperty,_1);if(!_1)return false;return this.selection.cellIsSelected(_1.$24t,_1.$24u)}
,isc.A.selectCell=function isc_CubeGrid_selectCell(_1,_2){if(_1!=null&&_1.$24t==null)_1=this.data.find(this.cellIdProperty,_1);if(!_1)return;return this.selection.setCellSelection(_1.$24t,_1.$24u,_2)}
,isc.A.deselectCell=function isc_CubeGrid_deselectCell(_1){this.selectCell(_1,false)}
,isc.A.selectCells=function isc_CubeGrid_selectCells(_1,_2){if(_2==null)_2=true;if(isc.isAn.Array(_1)){var _3=[];for(var i=0;i<_1.length;i++){var _5=_1[i];if(isc.isA.String(_5))_5=this.data.find(this.cellIdProperty,_5);_3[i]=[_5.$24t,_5.$24u]}
return this.selection.setCellListSelection(_3,_2)}
var _6=_1;var _7=this.data.findAll(_6);if(_7==null||_7.length==0)return false;_7=_7.objectsToArrays(["$24t","$24u"]);return this.selection.setCellListSelection(_7,_2)}
,isc.A.deselectCells=function isc_CubeGrid_deselectCells(_1){this.selectCells(_1,false)}
,isc.A.selectAllCells=function isc_CubeGrid_selectAllCells(){this.selection.selectAll()}
,isc.A.deselectAllCells=function isc_CubeGrid_deselectAllCells(){this.selection.deselectAll()}
,isc.A.getSelectedFacetValues=function isc_CubeGrid_getSelectedFacetValues(_1){var _2=_1?[_1]:this.getAllFacetIds(),_3=[];for(var i=0;i<_2.length;i++){var _1=_2[i],_5=this.getFacetLocation(_1);if(_5.isRow&&this.rowHeaderGridMode){var _6=this.getSelectedHeaderFields(_1),_7=this.map("getHeaderFacetValues",_6);_3.addList(_7)}else{var _8=this.getHeaderBar(_2[i]);if(_8==null)continue;var _9=_8.getButtons();for(var j=0;j<_9.length;j++){if(_9[j].isSelected()){_3.add(this.getHeaderFacetValues(_9[j]))}}}}
return _3}
,isc.A.getSelectedHeaderFields=function isc_CubeGrid_getSelectedHeaderFields(_1){var _2=[],_3=this.getFacetLocation(_1),_4=this.headerGrid.selection.getSelectedCells(),_5=this.rowFieldsVisualOrder||this.rowFields;for(var i=0;i<_4.length;i++){var _7=_4[i],_8=_7[1];if(_8!=_3.level)continue;var _9=this.headerGrid.getCellField(_7[0],_7[1]);_2.add(_9)}
return _2}
,isc.A.facetValuesSelected=function isc_CubeGrid_facetValuesSelected(_1){var _2=this.getHeader(_1);if(_2==null)return null;return _2.parentElement.selection.isSelected(_2)}
,isc.A.facetHasSelection=function isc_CubeGrid_facetHasSelection(_1){var _2=_1?[_1]:this.getAllFacetIds();var _3=false;for(var i=0;i<_2.length;i++){var _1=_2[i],_5=this.getFacetLocation(_1);if(_5.isRow&&this.rowHeaderGridMode){if(this.getSelectedHeaderFields(_1).length>0)_3=true;continue}
var _6=this.getHeaderBar(_2[i]);if(_6==null)continue;if(_6.selection.anySelected())_3=true}
return _3}
,isc.A.getFacetsHavingSelection=function isc_CubeGrid_getFacetsHavingSelection(){var _1=this.getAllFacetIds(),_2=[];for(var i=0;i<_1.length;i++){var _4=_1[i];if(this.facetHasSelection(_4))_2.add(_4)}
return _2}
,isc.A.selectFacetValues=function isc_CubeGrid_selectFacetValues(_1,_2){var _3=this.getHeader(_1);if(_3==null)return null;return _3.parentElement.selection.setSelected(_3,_2)}
,isc.A.deselectFacetValues=function isc_CubeGrid_deselectFacetValues(_1){this.selectFacetValues(_1,false)}
,isc.A.selectFacetValue=function isc_CubeGrid_selectFacetValue(_1,_2,_3){if(_3==null)_3=true;var _4=this.getHeaderBar(_1);if(!_4)return;var _5=_4.getButtons().findAll("facetValueId",_2);return _4.selection.selectList(_5,_3)}
,isc.A.deselectFacetValue=function isc_CubeGrid_deselectFacetValue(_1,_2){this.selectFacetValue(_1,_2,false)}
,isc.A.selectAllFacetValues=function isc_CubeGrid_selectAllFacetValues(_1,_2){var _3=[];if(_2==null)_2=true;if(_1==null){for(var i=0;i<this.facets.length;i++)_3[i]=this.facets[i].id}else{_3[0]=_1}
for(var i=0;i<_3.length;i++){var _5=this.getHeaderBar(_3[i]);if(!_5)continue;if(_2)_5.selection.selectAll();else _5.selection.deselectAll()}}
,isc.A.deselectAllFacetValues=function isc_CubeGrid_deselectAllFacetValues(_1){this.selectAllFacetValues(_1,false)}
,isc.A.deselectAll=function isc_CubeGrid_deselectAll(){this.deselectAllCells();this.deselectAllFacetValues()}
,isc.A.reorderField=function isc_CubeGrid_reorderField(_1,_2,_3){var _4=_2-_1,_5=this.fields[_1];this.selection.deselectAll();this.deselectHeaders(this.rowHeaders);this.deselectHeaders(this.colHeaders);this.cellIndex=null;var _6=(_2>_1),i=_1+(_6?1:-1),_8=[];while((_6&&i<=_2)||(!_6&&i>=_2))
{var _9=this.fields[i];if(_9.parent!=_5.parent)break;_8.add(_9.facetValueId);_6?i++:i--}
var _10=this.fields.duplicate();for(var i=0;i<_10.length;i++){var _9=_10[i];if(_9==_5||(_5.facetValueGroup!=null&&_9.facetValueGroup==_5.facetValueGroup&&_9.facetValueId==_5.facetValueId))
{var _11=this.passFacetValues(_10,i,_6,_8);var _4=this.getMoveGroupDelta(_10,i,_11);var _12=this.getMoveGroupExtents(_10,i);this.reorderFields(_12[0],_12[1]+1,_4)}}
this.rowBorders=this.getBorderStyles(this.innerRowFields,true);this.colBorders=this.getBorderStyles(this.innerColFields);this.rowBoundaries=this.getSelectionBoundaries(this.innerRowFields);this.colBoundaries=this.getSelectionBoundaries(this.innerColFields);if(this.$52b&&!isc.isA.emptyObject(this.$52b)){this.$31n()}
if(!_3){this.$26v=_1;this.$26w=_2;this.fieldReorderedByUser()}
if(this.facetValueReordered)this.facetValueReordered(_5.facetValueGroup)}
,isc.A.reorderFields=function isc_CubeGrid_reorderFields(_1,_2,_3){var _4=this.fields[_1],_5=_2-_1;if(_4.parent){var _6=_4.parent.childFacetValues.indexOf(_4);_4.parent.childFacetValues.slideRange(_6,_6+_5,_6+_3)}
this.Super("reorderFields",arguments)}
,isc.A.passFacetValues=function isc_CubeGrid_passFacetValues(_1,_2,_3,_4){var _5=isc.clone(_4),_6=_1[_2].parent;while((_3&&_2<_1.length)||(!_3&&_2>=0))
{var _7=_1[_2];if(_7.parent!=_6){return _3?_2-1:_2+1}
_5.remove(_7.facetValueId);if(_5.isEmpty()){return _2}
_3?_2++:_2--}
return _3?_1.length-1:0}
,isc.A.getMoveGroupExtents=function isc_CubeGrid_getMoveGroupExtents(_1,_2){var _3=_1[_2];if(_3.moveGroup==null)return[_2,_2];var _4=[];var i=_2;while(i>=0&&_1[i].moveGroup==_3.moveGroup&&_1[i].parent==_3.parent)i--;_4[0]=i+1;var i=_2;while(i<_1.length&&_1[i].moveGroup==_3.moveGroup&&_1[i].parent==_3.parent)i++;_4[1]=i-1;return _4}
,isc.A.nearestPositionWithinParent=function isc_CubeGrid_nearestPositionWithinParent(_1,_2,_3){if(_3>_1.length-1)_3=_1.length-1;if(_3<0)_3=0;var _4=_1[_2];if(_4.parent==_1[_3].parent){return _3}
var _5=_1.getProperty("parent");return(_3>_2?_5.lastIndexOf(_4.parent):_5.indexOf(_4.parent))}
,isc.A.getMoveGroupDelta=function isc_CubeGrid_getMoveGroupDelta(_1,_2,_3){var _4=this.getMoveGroupExtents(_1,_2);var _5=(_3>_2?_4[1]:_4[0]);var _6=_5+(_3-_2);var _7=this.nearestPositionWithinParent(_1,_5,_6);return _7-_5}
,isc.A.fieldReorderedByUser=function isc_CubeGrid_fieldReorderedByUser(){}
,isc.A.resizeFacetValue=function isc_CubeGrid_resizeFacetValue(_1,_2){return this.resizeField(null,_2,_1)}
,isc.A.resizeField=function isc_CubeGrid_resizeField(_1,_2,_3){if(_1!=null)_3=this.fields[_1].facetValueId;for(var i=0;i<this.fields.length;i++){var _5=this.fields[i];if(i==_1||_5.facetValueId==_3)
{this.header.resizeItem(i,_2);this.fields[i].width=_2;this.$26a[i]=_2}}
this.setBodyFieldWidths(this.$26a);if(_1!=null){this.$26x=_3;this.$26y=_2;this.fieldResizedByUser()}
this.$5y()}
,isc.A.fieldResizedByUser=function isc_CubeGrid_fieldResizedByUser(){}
,isc.A.rowResized=function isc_CubeGrid_rowResized(_1,_2){}
,isc.A.hiliteRecord=function isc_CubeGrid_hiliteRecord(_1,_2,_3){if(this.inlinedFacet)return this.Super("hiliteRecord",arguments);else _1[this.hiliteProperty]=_3.id}
,isc.A.getField=function isc_CubeGrid_getField(_1){if(!this.fields)return null;return isc.Class.getArrayItem(_1,this.fields,"id")}
,isc.A.getFieldNum=function isc_CubeGrid_getFieldNum(_1){if(!this.fields)return-1;if(isc.isA.Object(_1)&&(_1["id"]!=null)){_1=_1["id"]}
return isc.Class.getArrayItemIndex(_1,this.fields,"id")}
,isc.A.hiliteCell=function isc_CubeGrid_hiliteCell(_1,_2){if(isc.isA.Number(_1)){_1=this.getCellRecord(_1,_2);_2=arguments[2]}
if(!_1)return false;if(_1[this.hiliteProperty]==_2){return false}else{_1[this.hiliteProperty]=_2;this.refreshCells([[_1.$24t,_1.$24u]]);return true}}
,isc.A.hiliteCellList=function isc_CubeGrid_hiliteCellList(_1,_2){if(!isc.isAn.Array(_1))return false;var _3=[];for(var i=0,_5=_1.length,_6;i<_5;i++){_6=_1[i];if(!_6||_6[this.hiliteProperty]==_2)continue;_6[this.hiliteProperty]=_2;_3[_3.length]=[_6.$24t,_6.$24u]}
this.refreshCells(_3);return true}
,isc.A.hiliteFacetValue=function isc_CubeGrid_hiliteFacetValue(_1,_2,_3){var _4=this.getFacetValue(_1,_2);if(!_4)return false;if(_4[this.hiliteProperty]==_3){return false}else{var _5=[];if(this.innerColFields.length>0&&this.innerColFields[0].facet.id==_1){_4[this.hiliteProperty]=_3;for(var i=0,_7=this.numCols,_8=this.numRows,_9;i<_7;i++){_9=this.innerColFields[i];if(_9.facetValueId==_2){_9[this.hiliteProperty]=_3;for(var j=0;j<_8;j++)_5[_5.length]=[j,i]}}}
else if(this.innerRowFields.length>0&&this.innerRowFields[0].facet.id==_1){_4[this.hiliteProperty]=_3;for(var i=0,_7=this.numCols,_8=this.numRows,_11;i<_8;i++){_11=this.innerRowFields[i];if(_11.facetValueId==_2){_11[this.hiliteProperty]=_3;for(var j=0;j<_7;j++)_5[_5.length]=[i,j]}}}
else return false;this.refreshCells(_5);return true}}
,isc.A.refreshCells=function isc_CubeGrid_refreshCells(_1){var _2=this.body;if(_2==null)return;var _3=_2.showHiliteInCells;_2.showHiliteInCells=true;_2.refreshCellStyles(_1);_2.showHiliteInCells=_3}
,isc.A.setFacetTitle=function isc_CubeGrid_setFacetTitle(_1,_2){if(_2==null)return;var _3=this.getFacet(_1);if(_3==null)return;_3.title=_2;var _4=this.getHeader(_1);if(_4!=null)_4.setTitle(_2)}
,isc.A.setFacetTitleAlign=function isc_CubeGrid_setFacetTitleAlign(_1,_2){var _3=this.getFacet(_1);if(_3==null)return;_3.titleAlign=_2;var _4=this.getHeader(_1);if(_4!=null){_4.align=_2;_4.markForRedraw()}}
,isc.A.setFacetValueTitle=function isc_CubeGrid_setFacetValueTitle(_1,_2,_3){if(_3==null)return;var _4=this.getFacetValue(_1,_2);if(_4==null)return;_4.title=_3;var _5=this.getFacetLocation(_1);if(this.rowHeaderGridMode&&_5.isRow){var _6=this.rowFields[_5.level].findAll("facetValueId",_2);_6.setProperty("title",_3);this.headerGrid.markForRedraw()}else{var _7=this.getHeaderBar(_1);if(_7==null)return;var _8=_7.getButtons().findAll("facetValueId",_2);_8.map("setTitle",_3);if(this.autoSizeHeaders)this.delayCall("adjustHeaderHeights",[],0)}}
,isc.A.setFacetValueTitleAlign=function isc_CubeGrid_setFacetValueTitleAlign(_1,_2,_3){var _4=this.getFacetValue(_1,_2);if(_4!=null)_4.align=_3;var _5=this.getHeaderBar(_1);if(_5==null)return;var _6=_5.getButtons().findAll("facetValueId",_2);if(_6!=null){for(var i=0;i<_6.length;i++){_6[i].align=_3;_6[i].markForRedraw()}}}
,isc.A.getFacetValueLayout=function isc_CubeGrid_getFacetValueLayout(_1){var _2=this.getFacetValueGroup(_1),_3=(_2!=null?_2.facetId:_1),_4=this.getHeaderBar(_3).getButtons(),_5=(_2==null?_4:_4.findAll("facetValueGroup",_1));var _6=_5.getProperties(["facetValueId","width"]);return _6}
,isc.A.getInnerColumnFacetValueLayout=function isc_CubeGrid_getInnerColumnFacetValueLayout(){return this.colHeaders.last().getButtons().getProperties(["facetValueId","width"])}
,isc.A.getRowFacetLayout=function isc_CubeGrid_getRowFacetLayout(){return this.rowFacetLabels.getButtons().getProperties(["facetId","width"])}
,isc.A.getColumnFacetLayout=function isc_CubeGrid_getColumnFacetLayout(){var _1=[];for(var i=0;i<this.colHeaders.length;i++){_1[i]={facetId:this.colHeaders[i].facetId,height:this.colHeaders[i].getHeight()}}
return _1}
,isc.A.getMetricFacetValues=function isc_CubeGrid_getMetricFacetValues(){var _1=this.getFacet(this.metricFacetId);return(_1?_1.values:[this.getMetricFacetValue()])}
,isc.A.getMetricFacetValue=function isc_CubeGrid_getMetricFacetValue(_1){var _2=this.getFacet(this.metricFacetId);if(_2==null)return{id:this.valueProperty,title:this.valueTitle};if(isc.isAn.Object(_1))_1=_1[_2.id];if(_2!=null)return this.getFacetValue(this.metricFacetId,_1)}
,isc.A.getFacetChartMenu=function isc_CubeGrid_getFacetChartMenu(_1){}
,isc.A.getFacetValueChartMenu=function isc_CubeGrid_getFacetValueChartMenu(_1,_2){if(!this.haveRowFacets()||!this.haveColumnFacets())return null;var _3=this.getAllFacetIds();_3.removeList(isc.getKeys(_1));_3.remove(this.metricFacetId);if(_3.length>2){this.logWarn("can't chart, too many variable facets: "+this.echo(_3));return null}
this.lastFacetValues=_1;var _4=[],_5=this.getMetricFacetValues();for(var i=0;i<_5.length;i++){var _7=_5[i];_4.add({title:this.getChartTitle(_7,_3),click:"target.chartLast("+isc.Comm.serialize(_3)+","+isc.Comm.serialize(_7.id)+");"})}
return isc.Menu.create(this.contextMenuProperties,{data:_4})}
,isc.A.getCellChartMenu=function isc_CubeGrid_getCellChartMenu(_1,_2){var _3=this.lastFacetValues=this.getCellFacetValues(_1,_2),_4=_3[this.metricFacetId]||this.getMetricFacetValues()[0],_5=[];_3=isc.clone(_3);delete _3[this.metricFacetId];for(var _6 in _3){if(this.getFacet(_6).values.length<=1)continue;for(var _7 in _3){if(_6==_7)continue;if(this.getFacet(_7).values.length<=1)continue;var _8=[_6,_7];_5.add({title:this.getChartTitle(_4,_8),click:"target.chartLast("+isc.Comm.serialize(_8)+");"})}}
return isc.Menu.create(this.contextMenuProperties,{data:_5})}
,isc.A.chartLast=function isc_CubeGrid_chartLast(_1,_2){var _3=this.lastFacetValues,_2=_2||_3[this.metricFacetId];if(this.getFacet(this.metricFacetId))_3[this.metricFacetId]=_2;for(var i=0;i<_1.length;i++){delete _3[_1[i]]}
this.showChartDialog(_3,_1)}
,isc.A.getChartTitle=function isc_CubeGrid_getChartTitle(_1,_2){if(!isc.isAn.Array(_2))_2=[_2];_2=this.map("getFacet",_2);if(isc.isA.String(_1)){_1=this.getFacetValue(this.metricFacetId,_1)}
var _3=_1.title+" by "+_2.getProperty("title").join(" and ");return _3}
,isc.A.getChartSubtitle=function isc_CubeGrid_getChartSubtitle(_1){var _2;if(isc.isAn.Array(_1)){_2=_1}else if(isc.isAn.Object(_1)){_2=[];for(var _3 in _1){if(_3==this.metricFacetId)continue;_2.add(this.getFacetValue(_3,_1[_3]))}}
if(_2!=null){return" for "+_2.getProperty("title").join(", ")}
return""}
,isc.A.makeChart=function isc_CubeGrid_makeChart(_1,_2,_3,_4,_5){_1=_1||{};var _6=this.map("getFacet",_2);if(_6.length>1&&this.chartConfirmThreshold>0){var _7=_6[0].values.length*
_6[1].values.length;if(_7>this.chartConfirmThreshold&&!_5){var _8=this,_9=function(_12){if(_12)_8.makeChart(_1,_2,_3,_4,true)},_10="Chart "+_7+" values?";if(isc.confirm){isc.confirm(_10,_9)}else{if(confirm(_10))_9(true)}
return}}
var _11=this.$43u(_1,_2,_3,_4,this.dataSource!=null);if(this.dataSource){var _8=this;this.getDataSource().fetchData(_1,function(_12,_13,_14){_8.$258(_12,_13,_14);_8.$43v(_11,_1)})}
return _11}
,isc.A.$43v=function isc_CubeGrid__populateChart(_1,_2){var _3=this.data.findAll(_2);_1.setData(_3)}
,isc.A.$43u=function isc_CubeGrid__finishChart(_1,_2,_3,_4,_5){var _6=this.getMetricFacetValue(_1),_7=this.getChartTitle(_6,_2),_8=this.getChartSubtitle(_1),_9=this.map("getFacet",_2);for(var i=0;i<_9.length;i++){var _11=_9[i].values,_12=[];for(var j=0;j<_11.length;j++){var _14=_11[j];if(this.chartOmitSums&&(_14.isFolder||_14.isSum))continue;if(_14.hidden)continue;_12.add(_14)}
_9[i]=isc.addProperties({},_9[i],{values:_12})}
var _15=isc.ClassFactory.getClass(this.chartConstructor).create(isc.addProperties({title:_7,subTitle:_8,chartType:this.chartType,facets:_9,valueTitle:_6.title,valueProperty:this.valueProperty,autoDraw:false,data:_5?[]:this.data.findAll(_1)},_3));if(this.showPlainCharts||!isc.DynamicForm){var _16=isc.VLayout.create({autoDraw:true,left:"10%",top:"10%",width:"60%",height:"60%",border:"2px solid #333333",backgroundColor:"white",canDragResize:true,canDragReposition:true,members:[isc.Label.create({autoDraw:false,dragTarget:"parent",contents:"Chart",backgroundColor:"#DDDDDD",padding:3,icon:"[SKIN]actions/remove.png",iconOrientation:"right",iconAlign:"right",align:"left",height:20,width:"100%",iconClick:function(){_16.destroy()}}),_15]})
return _15}
if(!_4)return _15;var _17=isc.ToolStrip.create({autoDraw:false,members:[isc.DynamicForm.create({autoDraw:false,chart:_15,numCols:4,width:"100%",items:[{type:"select",title:"Chart Type",valueMap:["Bar","Line","Column","Area","Pie","Doughnut"],changed:"form.chart.setChartType(value)"},{type:"checkbox",title:"Stacked",changed:"form.chart.setStacked(value)"}]})]})
isc.Window.create({autoDraw:true,title:"Chart",left:"10%",top:"10%",width:"80%",height:"60%",showFooter:false,animateMinimize:true,canDragReposition:true,canDragResize:true,items:[_15,_17]});return _15}
,isc.A.showChartDialog=function isc_CubeGrid_showChartDialog(_1,_2,_3,_4){this.makeChart(_1,_2,_3,_4||{})}
,isc.A.makeCellContextItems=function isc_CubeGrid_makeCellContextItems(_1,_2,_3){var _4=[];if(this.hilites){var _5=[],_6=[],_7=this.selection.cellIsSelected(_2,_3);for(var i=0;i<this.hilites.length;i++){var _9=this.hilites[i];if(_7){_5.add({title:(_9.title||_9.id),click:"target.hiliteCellList(target.getSelectedCells(),"+i+")"})}else{_5.add({title:(_9.title||_9.id),click:"target.hiliteCell("+_2+","+_3+","+i+")",checked:_1[this.hiliteProperty]==i})}
var _10=!_9.disabled;_6.add({title:(_9.title||_9.id),click:"target.enableHilite("+i+","+!_10+")",checked:_10})}
_5.addList([{isSeparator:true},{title:"None",click:(_7?"target.hiliteCellList(target.getSelectedCells())":"target.hiliteCell("+_2+","+_3+")")}]);_6.addList([{isSeparator:true},{title:"Show all",click:"target.enableHiliting()"},{title:"Hide all",click:"target.enableHiliting(false)"}]);_4.add({title:(_7?"Highlight Selection":"Highlight Cell"),submenu:isc.Menu.create(this.contextMenuProperties,{data:_5})});_4.add({title:"Show Highlights",submenu:isc.Menu.create(this.contextMenuProperties,{data:_6})})}
_4.add({title:"Show Hover Tips",click:"target.body.canHover = target.canHover = "+!this.canHover,checked:this.canHover});if(this.enableCharting){var _11=this.getCellChartMenu(_2,_3);if(_11!=null){_4.add({title:"Chart",submenu:_11})}}
return _4}
);isc.evalBoundary;isc.B.push(isc.A.makeFacetValueContextItems=function isc_CubeGrid_makeFacetValueContextItems(_1,_2,_3){var _4=[],_5=this.getHeaderBar(_2),_6=_5.vertical,_7=this.getEventRow(),_8=this.getEventColumn();if(this.canPickFields){var _9=this.getFacet(_2),_10=isc.clone(_1),_11=[];for(var i=0;i<_9.values.length;i++){var _13=_9.values[i];_10[_2]=_13.id;if(this.hideEmptyFacetValues&&!this.facetValuesArePresent(_10))continue;var _14=this.getFieldProperty(_10,"hidden"),_15={title:this.getSummaryTitle(_13),checked:!_14,click:this.getID()+(_14?".show":".hide")+"FacetValues("+isc.Comm.serialize(_10)+")"};_11.add(_15)}
var _16=_11.findAll("checked",true);if(_16&&_16.length==1)_16[0].enabled=false;_4.add({title:this.fieldVisibilitySubmenuTitle,icon:"[SKINIMG]actions/column_preferences.png",submenu:_11})}
if(!_6&&_5.isInnerMost){_4.addList([{title:"AutoFit Column",click:"target.autoSizeBodyColumn("+_8+")"},(_3.minimized?{title:"Maximize Column",click:"target.minimizeColumn("+_8+", false)"}:{title:"Minimize Column",click:"target.minimizeColumn("+_8+")"})])}
if(this.canRenameFacetValues){_4.addList([{title:"Rename...",click:"target.setFacetValueTitle('"+_2+"','"+_1[_2]+"',prompt('Enter the new name for this facet value:','"+this.getFacetValue(_2,_1[_2]).title+"'))"}])}
if(this.hilites&&_5.isInnerMost){var _17=[],_18=(_6?this.innerRowFields[_7][this.hiliteProperty]:this.innerColFields[_8][this.hiliteProperty])
for(var i=0;i<this.hilites.length;i++){var _19=this.hilites[i];_17.add({title:(_19.title||_19.id),click:"target.hiliteFacetValue("+isc.Comm.serialize(_2)+","+isc.Comm.serialize(_1[_2])+","+i+")",checked:i==_18})}
_17.addList([{isSeparator:true},{title:"None",click:"target.hiliteFacetValue("+isc.Comm.serialize(_2)+","+isc.Comm.serialize(_1[_2])+")"}]);_4.add({title:"Highlight",submenu:isc.Menu.create(this.contextMenuProperties,{data:_17})})}
if(this.enableCharting){var _20=this.getFacetValueChartMenu(_1,_2);if(_20!=null){_4.add({title:"Chart",submenu:_20})}}
return _4}
,isc.A.makeFacetContextItems=function isc_CubeGrid_makeFacetContextItems(_1){var _2=[];if(this.getFacetLocation(_1).isRow){_2.add({title:"AutoFit",click:"target.autoSizeFacet('"+_1+"')"})}
if(this.canRenameFacets){_2.add({title:"Rename...",click:"target.setFacetTitle('"+_1+"',prompt('Enter the new name for this facet:','"+this.getFacet(_1).title+"'))"})}
if(this.enableCharting){var _3=this.getFacetChartMenu(_1);if(_3!=null){_2.add({title:"Chart",submenu:_3})}}
return _2}
,isc.A.getFacetPath=function isc_CubeGrid_getFacetPath(_1){var _2=null;while(true){if(_2==null)_2=_1.facetValueId;else _2+=_1.facetValueId;if(_1.parent==null)break;_1=_1.parent;_2+=isc.dot}
return _2}
,isc.A.columnFacetResized=function isc_CubeGrid_columnFacetResized(_1,_2){var _3=this.columnFacets[_1];this.getFacet(_3).height=_2;var _4=this.getHeaderBar(_3);_4.setHeight(_2);_4.layoutChildren();this.layoutChildren();this.$5y()}
,isc.A.rowFacetResized=function isc_CubeGrid_rowFacetResized(_1,_2){this.rowFacetLabels.resizeItem(_1,_2);var _3=this.rowHeadersVisualOrder||this.rowHeaders,_4=_3[_1];var _5=this.rowFacetLabels,_6=_5.members.map("getVisibleWidth").sum();_5.setWidth(_6);if(this.rowHeaderGridMode){this.headerGrid.setColumnWidth(_1,_2);this.headerGrid.setWidth(_6);this.headerGrid.redraw()}else{var _7=_4.members;_7.map("setWidth",_2);_4.setWidth(_2);this.adjustRowHeaderBars()}
this.layoutChildren();this.$5y();if(this.autoSizeHeaders){this.rowHeights=null;this.delayCall("adjustHeaderHeights",[],0)}}
,isc.A.rowFacetBarResized=function isc_CubeGrid_rowFacetBarResized(_1,_2){this.rowFacetLabels.resizeTo(null,_2);if(this.haveColumnFacets())this.header.resizeTo(null,_2);this.layoutChildren();this.$5y()}
,isc.A.rowFacetReordered=function isc_CubeGrid_rowFacetReordered(_1,_2){if(this.rowHeaderGridMode&&!this.rowNesting){if(this.rowGridSelection)this.rowGridSelection.deselectAll();if(!this.rowFieldsVisualOrder)this.rowFieldsVisualOrder=this.rowFields.duplicate();var _3=this.rowFieldsVisualOrder;_3.slide(_1,_2);this.headerGrid.setColumnWidths(this.getRowFacetWidths());if(this.facetReordered)this.facetReordered();if(this.facetMoved)this.facetMoved();return}
this.moveFacet(this.rowFacets[_1],true,_2)}
,isc.A.facetDragReordered=function isc_CubeGrid_facetDragReordered(_1,_2){var _3=isc.EH.dragTarget.parentElement,_4=_3.dragStartPosition,_5=(_3.vertical?this.columnFacets:this.rowFacets),_6=(_1.vertical?this.columnFacets:this.rowFacets);this.moveFacet(_5[_4],_6,_2)}
,isc.A.moveFacet=function isc_CubeGrid_moveFacet(_1,_2,_3){var _4=this.getFacetLocation(_1);if(_4==null){this.logWarn("ignoring attempt to move facet which is not part of current view: "+_1);return}
var _5=_4.isRow?this.rowFacets:this.columnFacets,_6=_2?this.rowFacets:this.columnFacets,_7=_5.indexOf(_1);if(_3==_6.length-1&&this.getFacet(_6.last()).inlinedValues){_3-=1}
var _8=_3;if(_5.length<=1||(_5==_6&&_7==_8))return;var _9=_5[_7];if(_5==_6){var _10=_8>_7;_5.addAt(_9,(_10?_8+1:_8));_5.removeItem(_10?_7:_7+1)}else{_5.removeItem(_7);_6.addAt(_9,_8)}
this.selection.deselectAll();this.cellIndex=null;this.$24q();if(_5===_6){if(_5==this.rowFacets)this.setRows(null,null,true);else this.setColumns(null,null,true)}else{this.setColumns(null,null,true);this.setRows(null,null,true)}
if(this.autoSizeHeaders)this.adjustHeaderHeights();if(this.$52b&&!isc.isA.emptyObject(this.$52b)){this.$31n()}
if(this.facetReordered)this.facetReordered(_9);if(this.facetMoved)this.facetMoved(_9)}
,isc.A.adjustRowHeaderBars=function isc_CubeGrid_adjustRowHeaderBars(){var _1=this.rowHeadersVisualOrder||this.rowHeaders;var _2=0;for(var i=0;i<_1.length;i++){var _4=_1[i];_4.setLeft(_2);_2+=_4.getWidth()}
return _2}
,isc.A.addRowFacet=function isc_CubeGrid_addRowFacet(_1,_2){return this.addFacet(_1,true,_2)}
,isc.A.addColumnFacet=function isc_CubeGrid_addColumnFacet(_1,_2){return this.addFacet(_1,false,_2)}
,isc.A.addFacet=function isc_CubeGrid_addFacet(_1,_2,_3){if(this.getFacet(_1)==null){this.logWarn("ignoring attempt to add facet with no definition: "+_1);return}
if(_2==null)_2=true;var _4=(_2?this.rowFacets:this.columnFacets);if(_3==null)_3=_4.length;var _5=this.getFacetLocation(_1);if(_5!=null){if(_5.isRow==_2){if(_3>_5.level)_3-=1}
return this.moveFacet(_1,_2,_3)}
if(this.fixedFacetValues[_1]==null&&this.dataSource){this.logWarn("added facet: "+_1+" had no fixed facet value: "+"load on demand was probably broken up until now")}
delete this.fixedFacetValues[_1];if(_3==_4.length-1&&this.getFacet(_4.last()).inlinedValues){_3-=1}
_4.addAt(_1,_3);_2?this.setRows():this.setColumns();if(this.facetAdded)this.facetAdded(_1)}
,isc.A.removeFacet=function isc_CubeGrid_removeFacet(_1,_2){var _3=this.getFacetLocation(_1);if(_3==null){this.logWarn("ignoring attempt to remove facet not present in current view: "+_1);return}
var _4=_3.isRow?this.rowFacets:this.columnFacets;if(_4.length<=1)return;if(_2==null){var _5=this.getRollupValue(_1);if(_5==null)_5=this.getMinimizeValues(_1)[0];_2=_5.id;this.logWarn("no fixedFacetValueId specified on removeFacet, using: "+_2)}
if(this.fixedFacetValues==null)this.fixedFacetValues={};this.fixedFacetValues[_1]=_2;var _6=(_3.isRow?this.rowFacets:this.columnFacets);_6.remove(_1);if(this.$26z!=null&&(this.$25d==_1||this.$25e==_1))
{this.$26z=false;var _7=this.getFacet(this.$25d);delete _7.combineInTree}
_3.isRow?this.setRows():this.setColumns();if(this.facetRemoved)this.facetRemoved(_1)}
,isc.A.setFixedFacetValue=function isc_CubeGrid_setFixedFacetValue(_1,_2){if(this.getFacetLocation(_1)!=null){this.removeFacet(_1,_2);return}
this.fixedFacetValues[_1]=_2;this.cellIndex=null;if(this.$52b&&!isc.isA.emptyObject(this.$52b)){this.$31n()}
this.$25a()}
,isc.A.addFacetAtField=function isc_CubeGrid_addFacetAtField(_1,_2){var _3=this.getFacet(_1);if(_3==null){this.logWarn("addFacetAtField: no such facet: "+_1);return}
var _4=this.getContainingFacet(this.getHeaderFacetValues(_2)),_5=this.getFacet(_4);_3.canCollapse=true;_5.minimized=true;this.setFieldProperty(_2,"minimized",false);if(_2.isRowHeader)_3.combineInTree=true;this.$26z=true;this.addFacet(_1,_2.isRowHeader)}
,isc.A.willAcceptDrop=function isc_CubeGrid_willAcceptDrop(){return isc.EH.dragTarget.facetId!=null}
,isc.A.dropMove=function isc_CubeGrid_dropMove(){var _1=this.getEventRow(),_2=this.getEventColumn();if(_1>=0&&_2>=0){this.showHDragLine(this.getPageLeft()+this.bodyOffsetX,this.getPageTop()+this.bodyOffsetY)}}
,isc.A.drop=function isc_CubeGrid_drop(){var _1=this.getEventRow(),_2=this.getEventColumn();if(_1>=0&&_2>=0){this.addFacet(isc.EH.dragTarget.facetId,false,this.columnFacets.length)}}
,isc.A.buildSumFacets=function isc_CubeGrid_buildSumFacets(){this.allSums=[];for(var i=0;i<this.facets.length;i++){var _2=this.facets[i];if(_2.dontSum)continue;var _3=_2.isTree?_2.$246.getChildren(_2.$246.getRoot()):_2.values;var _4=_3.getProperty("id");var _5=this.sumFacetValues(_2.id,"sum",_4);this.allSums.addList(_5);this.data.addList(_5)}}
,isc.A.fillTreeData=function isc_CubeGrid_fillTreeData(){var _1=this.facets.findAll("isTree",true);this.allSums=[];for(var i=0;i<_1.length;i++){var _3=_1[i];var _4=_3.$246;this.fillTreeDataForFacetValue(_3.id,_3.$246,_3.$246.root)}}
,isc.A.fillTreeDataForFacetValue=function isc_CubeGrid_fillTreeDataForFacetValue(_1,_2,_3){var _4=_2.getChildren(_3);if(_4==null||_4.length==0)return null;var _5=[];for(var i=0;i<_4.length;i++){var _7=_4[i],_8=this.fillTreeDataForFacetValue(_1,_2,_4[i]);if(_8!=null)_5.addList(_8)}
if(_5.length==0){_5=this.data}else{this.data.addList(_5);this.allSums.addList(_5)}
if(_3==_2.root)return;return this.sumFacetValues(_1,_3.id,_4.getProperty("id"),_5)}
,isc.A.sumFacetValues=function isc_CubeGrid_sumFacetValues(_1,_2,_3,_4){if(_4==null)_4=this.data;var _5=this.getAllFacetIds();_5.remove(_1);var _6=0,_7=null;for(var i=0;i<_5.length;i++){var _9=this.getFacet(_5[i]);if(_9.values.length>_6){_6=_9.values.length;_7=_9.id}}
var _10=[],_11={};var _12={},_13="";for(var i=0;i<_3.length;i++){_12[_3[i]]=_13}
for(var i=0;i<_4.length;i++){var _14=_4[i];if(_12[_14[_1]]==null)continue;var _15=_14[_7];var _16=_11[_15];if(_16==null){_11[_15]=[];_16=_11[_15]}
var _17=this.findMatch(_16,_14,_5);if(_17==null){_17=isc.addProperties({},_14);_17[_1]=_2;_17.value=0;_10.add(_17);_16.add(_17)}
_17.value+=_14.value}
return _10}
,isc.A.findMatch=function isc_CubeGrid_findMatch(_1,_2,_3){var l=_1.length;for(var i=0;i<l;i++){var _6=_1[i];if(_6==null)continue;var _7=true;for(var j=0;j<_3.length;j++){var _9=_3[j];if(_6[_9]!=_2[_9]){_7=false;break}}
if(_7)return _6}
return null}
,isc.A.pivotFacetValue=function isc_CubeGrid_pivotFacetValue(_1,_2,_3,_4,_5){if(!this.multiCellData){this.logWarn("facetValuePivoting is only allowed with multiCellData:true");return}
var _6=this.getFacet(_1);if(!_4){var _7=_3,_8=(this.inlinedFacet&&this.inlinedFacet.id==_1);if(!_8){_7=isc.addProperties({},_7);_7[_1]=_2}
var _9=this.data.findAll(_7)||[],_10=_8?_2:this.valueProperty;_4=_9.getProperty(_10).getUniqueItems();this.logInfo("with criteria: "+this.echo(_7)+", found "+_9.length+" records, under property: '"+_10+"', derived pivotValues: "+_4,"facetValuePivot")}
var _11={pivotFacetValueId:_2,pivotValues:_4};this.setFieldProperty(_3,"pivot",_11);this.cellIndex=null;this.pivotWithinFacet=_1;if(!_5){this.setFacets();this.setRows();this.setColumns()}}
,isc.A.getPivotFacetValues=function isc_CubeGrid_getPivotFacetValues(_1,_2,_3){var _4=this.getHeaderFacetValues(_1),_5=this.getFieldProperty(_4,"pivot");if(!_5)return null;var _6=_5.pivotValues,_7=this.getFacetValue(_2,_5.pivotFacetValueId);if(this.logIsInfoEnabled("facetValuePivot")){this.logInfo("at facetValues: "+this.echo(_4)+", pivot info: "+this.echo(_5),"facetValuePivot")}
var _8=[];for(var i=0;i<_6.length;i++){var _10=_6[i];for(var j=0;j<_3.length;j++){var _12=_3[j];if(_12==_5.pivotFacetValueId)continue;var _13=this.getFacetValue(_2,_12);_8.add({facetValueId:_12,title:this.getPivotedFacetValueTitle(_13,_7,_10),pivotValue:_10,pivotFacetValueId:_5.pivotFacetValueId})}}
return _8}
,isc.A.getPivotedFacetValueTitle=function isc_CubeGrid_getPivotedFacetValueTitle(_1,_2,_3){return _1.title+" ("+_2.title+":"+_3+")"}
,isc.A.getClientExportData=function isc_CubeGrid_getClientExportData(_1){var _2=this.logIsDebugEnabled("cubeGridExport");var _3=this.rowFacets,_4=this.innerColFields,_5=this.rowFields,_6=_1&&_1.separatorString;if(_6==null)_6=this.exportSeparatorString;var _7=(_1&&_1.omitRepeatingValues);var _8=_1&&_1.combineRows;if(_8==null)_8=true;var _9=[];var _10=[],_11=[];var _12=_5.length,_13=_5[_12-1],_14,_15;var _16;var _17=[],_18={};if(_2){this.logDebug("About to do export. Combine rows:"+_8+", omitRepeats:"+_7+" - iterating through "+_13.length+" total rows. RowFields:"+this.echo(_5),"cubeGridExport")}
for(var _19=0;_19<_13.length;_19++){var _20={};if(!_8){_9[_9.length]=_20}
var _21=_13[_19],_22=[];while(_21!=null){_22[_22.length]=_21;_21=_21.parent}
if(_2){this.logDebug("rownum:"+_19+" - set of row-fields for this row (inner to outer):"+_22.getProperty("title"),"cubeGridExport")}
var _23=_7;if(_23==null)_23=_8;var _24=_23;for(var _25=_22.length;_25>0;_25--){var _26=_12-_25,_27=_22[_25-1];if(_26==0){if(_19==0){_14=_27;_15=true;if(_8&&_26==0){_16={};_9[_9.length]=_16}}else{_15=(_14!=_27);if(_15){_14=_27;if(_8){_16={};_9[_9.length]=_16}}}}
var _28=_27.facet;if(_28.showInExport==false){if(_2){this.logDebug("not collecting value for field:"+this.echo(_27),"cubeGridExport")}
continue}
var _29=_10[_26];if(_29==null){_10[_26]=this.getExportHeaderTitle(this.getFacet(_3[_26]),null,_1);_10[_26]=this.htmlUnescapeExportFieldValue(_10[_26]);_29=_10[_26]}
var _30=_27.title||_27.id;if(_23){if(_2){this.logDebug("Determining whether can omit value. Parent suppressed omit:"+(!_24)+". Current val calculated as:"+_30+" - fieldNum:"+_26+" prev set of vals:"+this.echo(_17),"cubeGridExportLogs")}
if(_15){_17[_26]=_30}else{if(_17[_26]==_30){if(_24){_30=""}}else{_17[_26]=_30;_24=false}}}
if(_8){if(_15){_16[_29]=[_30]}else{_16[_29][_16[_29].length]=_30}}else{_20[_29]=this.htmlUnescapeExportFieldValue(_30)}}
for(var _31=0;_31<_4.length;_31++){if(_11[_31]==null){_11[_31]=this.getExportHeaderTitle(_4[_31].facet,_4[_31],_1);_11[_31]=this.htmlUnescapeExportFieldValue(_11[_31])}
var _32=_11[_31],_33=_7;if(_33==null){if(_4[_31].omitRepeatingValues!=null){_33=_4[_31].omitRepeatingValues}else{_33=(_8?true:false)}}
var _34=this.getCellValue(this.getCellRecord(_19,_31),_19,_31);if(_33){var _35=_18[_32];if(_19==0){_18[_32]=_34}else{if(_35!=_34)_18[_32]=_34;else _34=""}}
if(_8){if(_15){_16[_32]=[_34]}else{_16[_32][_16[_32].length]=_34}}else{_20[_32]=this.htmlUnescapeExportFieldValue(_34)}}
if(_8){if(_19==_13.length-1){this.$75t(_16,_6)}
if(_15&&_9.length>0){this.$75t(_9[_9.length-2],_6)}}}
return _9}
,isc.A.$75t=function isc_CubeGrid__combineArrayExportValueToString(_1,_2){if(this.logIsDebugEnabled("cubeGridExport")){this.logDebug("About to convert array values to strings -- raw record:"+isc.echoFull(_1),"cubeGridExport")}
for(var _3 in _1){var _4=_1[_3],_5=_4.join(_2);_1[_3]=this.htmlUnescapeExportFieldValue(_5)}}
,isc.A.getExportHeaderTitle=function isc_CubeGrid_getExportHeaderTitle(_1,_2,_3){if(_2==null){return _1.title||_1.id}
var _4=this.colFields.last().indexOf(_2),_5=(_3&&_3.facetSeparatorString)||this.exportFacetSeparatorString,_6;while(_2!=null){if(_2.facet&&_2.facet.showInExport!=false){var _7=_2.title;if(_7==null)_7=_2.id;if(_6==null)_6=_7;else _6=_7+_5+_6}
_2=_2.parent}
return _6}
,isc.A.$749=function isc_CubeGrid__getTopField(_1){var _2=_1;if(_2==null)return;while(_2.parent!=null){_2=_2.parent}
return _2}
);isc.B._maxIndex=isc.C+303;isc.CubeGrid.registerStringMethods({facetValueSelectionChanged:"facetValues,newState",facetValueOver:"facetValues",facetValueOut:"facetValues",facetValueHover:"facetValues",facetValueHoverHTML:"facetValues",facetLabelHoverHTML:"facetId",facetValueContextClick:"facetValues,facetId",facetValueReordered:"groupId",facetAdded:"facetId",facetRemoved:"facetId",facetMoved:"facetId",facetReordered:"facetId",hideFacet:"facetId",hideFacetValues:"facetId",sortByFacetValues:"facetValues, sortDirection",sortByFacetId:"facetId, sortDirection",facetLabelOver:"facetId",facetLabelOut:"facetId",facetLabelHover:"facetId"});isc.ClassFactory.defineClass("HeaderGrid","GridRenderer");isc.A=isc.HeaderGrid.getPrototype();isc.A.cellPadding=0;isc.A.cellHeight=22;isc.A.isRowHeader=true;isc.A.isInnerMost=true;isc.A.vertical=true;isc.A.showRollOver=true;isc.A.useCellRollOvers=true;isc.A.canDrag=true;isc.A.dragAppearance="none";isc.A.canDragSelect=true;isc.A.canSelectCells=true;isc.A.canAcceptDrop=true;isc.A.fastCellUpdates=true;isc.A=isc.HeaderGrid.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.B.push(isc.A.getCellField=function isc_HeaderGrid_getCellField(_1,_2){var _3=this.cubeGrid;if(_3.rowAttributeLOD){var _4=this.fields[_2].facetId;return _3.$24r.get(_1)[_4]}
if(!_3.rowNesting&&!_3.$25c){var _5=_3.rowFieldsVisualOrder||_3.rowFields;return _5[_2][_1]}
var _6=_3.innerRowFields,_7=_6[_1],_8=this.fields[_2];if(_3.$25c&&_2==this.fields.length-1){return _7}
var _4=_8.facetId;while(_7.facet.id!=_4){_7=_7.parent}
return _7}
,isc.A.getWithinFacetIndent=function isc_HeaderGrid_getWithinFacetIndent(_1){if(!_1.facet.isTree)return 0;var _2=_1.facet.$246.getLevel(_1)-1;var _3=this.cubeGrid;if(_3.$25c&&_1.facet.id==_3.$25d){var _4=_3.getRollupValue(_3.$25d);if(_4&&_4.parentId==null&&_4.$244.length>0)
{_2--}}
return _2*20}
,isc.A.getCellValue=function isc_HeaderGrid_getCellValue(_1,_2,_3){var _4=this.cubeGrid,_5=this.fields[_3].$25f,_6=this.getCellField(_2,_3);if(_6==null)return this.emptyCellValue;var _7=_6.title,_8=this.fields[_3].align,_9=_4.shouldShowTurndown(_6);var _10=this.getWithinFacetIndent(_6);if(_5&&_4.$25d==_6.facet.id){var _11=_6.parent;_10+=20;_10+=this.getWithinFacetIndent(_11)}
if(_9){_7=_4.addTurndown(_7,_6)}else if(_5||_6.facet.isTree){_10+=16}
if(_10>0){_7=isc.Canvas.spacerHTML(_10,1)+_7;return _7}
if(!_4.padTitles||_8==isc.Canvas.CENTER)return _7;if(_8==isc.Canvas.RIGHT)return _7+"&nbsp;";else if(_8==isc.Canvas.LEFT)return"&nbsp;"+_7;return _7}
,isc.A.getCellCSSText=function isc_HeaderGrid_getCellCSSText(_1,_2,_3){var _4=this.cubeGrid,_5=this.getCellField(_2,_3);if(_5==null)return null;if(_4.flatAttributesOnly()){var _6=_4.getFacet(_5.facet)[_4.hiliteProperty];if(_6==null)return null;return _4.getHiliteCSSText(_6)}else{return _5.cssText}}
,isc.A.getRowSpan=function isc_HeaderGrid_getRowSpan(_1,_2,_3){if(!this.cubeGrid.rowNesting)return;if(_3==this.fields.length-1)return 1;var _4=this.getCellField(_2,_3);if(_4==null){this.logWarn("couldn't find field for: "+[_2,_3]);return}
var _5=this.cubeGrid.getHeaderSpan(_4),_6=_5[1]-_5[0]+1;return _6-(_2-_5[0])}
,isc.A.getRowHeight=function isc_HeaderGrid_getRowHeight(_1,_2){var _3=this.cubeGrid;if(!_3.multiRowHeaders)return this.Super("getRowHeight",arguments);var _4=this.getCellField(_2,this.fields.length-1);return _4.groupCount*_3.cellHeight}
,isc.A.drop=function isc_HeaderGrid_drop(){if(!this.cubeGrid.canBreakout)return;var _1=this.getEventRow(),_2=this.getEventColumn();var _3=this.getCellField(_1,_2);this.cubeGrid.addFacetAtField(isc.EH.dragTarget.facetId,_3)}
,isc.A.redraw=function isc_HeaderGrid_redraw(){this.Super("redraw",arguments);var _1=this.cubeGrid;if(_1.autoSizeHeaders){_1.rowHeights=this.$26b()}}
,isc.A.markForRedraw=function isc_HeaderGrid_markForRedraw(_1){var _2=this.Super("markForRedraw",arguments);if(_1=="scrollRedraw"){var _3=this.cubeGrid;_3.body.markForRedraw("headerGrid redrawing")}
return _2}
,isc.A.getDrawArea=function isc_HeaderGrid_getDrawArea(){var _1=this.Super("getDrawArea",arguments);var _2=this.cubeGrid;if(!_2.multiRowHeaders)return _1;var _3=_2.innerRowFields,_4=0,_5,_6=0,_7=Math.floor(this.getScrollTop()/_2.body.getAvgRowHeight()),_8=_7+Math.ceil(this.getViewportHeight()/this.cellHeight),_9=0;for(var i=0;i<_3.length;i++){var _11=_3[i];if((_6+_11.groupCount)>=_7&&_4==null){_4=i;_9=_6}
_6+=_11.groupCount;if(_6>_8){_5=i+1;break}}
if(_5==null)_5=_3.length-1;if(_4>0){var _12=_2.body.getAvgRowHeight()*_4,_13=_9*this.getAvgRowHeight();this.startSpace=_13-_12}else{this.startSpace=0}
this.endSpace=_2.groupedTotalRows*_2.body.getAvgRowHeight();_1[0]=_4;_1[1]=_5;return _1}
,isc.A.cellOver=function isc_HeaderGrid_cellOver(_1,_2,_3){var _4=this.cubeGrid,_5=this.getCellField(_2,_3);return _4.$26f(_4.getHeaderFacetValues(_5))}
,isc.A.cellOut=function isc_HeaderGrid_cellOut(_1,_2,_3){var _4=this.cubeGrid,_5=this.getCellField(_2,_3);if(_4.facetValueOut)_4.facetValueOut(_4.getHeaderFacetValues(_5))}
,isc.A.cellContextClick=function isc_HeaderGrid_cellContextClick(_1,_2,_3){var _4=this.cubeGrid,_5=this.getCellField(_2,_3);return _4.$26g(_5)}
);isc.B._maxIndex=isc.C+13;isc.ClassFactory.defineClass("ReportHeaderBar","Toolbar");isc.A=isc.ReportHeaderBar;isc.A.buttonProperties={getActionType:function(){return isc.Button.BUTTON},mouseDown:function(){var _1=this.parentElement.itemMouseDown();this.Super("mouseDown",arguments);return _1},mouseUp:function(){this.parentElement.itemMouseUp();return this.Super("mouseUp",arguments)},mouseOver:function(){this.Super("mouseOver",arguments);var _1=this.cubeGrid;return _1.$26f(_1.getHeaderFacetValues(this))},mouseOut:function(){this.Super("mouseOut",arguments);var _1=this.cubeGrid;if(_1.facetValueOut)_1.facetValueOut(_1.getHeaderFacetValues(this))},keyPress:function(){var _1=isc.EventHandler.lastEvent.keyName;if(_1=="Space"||_1=="Enter"){this.parentElement.startSelecting(this)}},showContextMenu:function(){var _1=this.cubeGrid;return _1.$26g(this)},doubleClick:function(){this.cubeGrid.facetValueDoubleClick(this.cubeGrid.getHeaderFacetValues(this))}};isc.A=isc.ReportHeaderBar.getPrototype();isc.A.canDragSelectItems=true;isc.A.tabWithinToolbar=false;isc.A.buttonDefaults={showFocused:false};isc.A=isc.ReportHeaderBar.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.mouseMove=isc.EventHandler.stopBubbling;isc.A.mouseOver=isc.EventHandler.stopBubbling;isc.B.push(isc.A.initWidget=function isc_ReportHeaderBar_initWidget(){this.Super(this.$oc);if(this.buttonProperties==null)this.buttonProperties={};isc.addProperties(this.buttonProperties,isc.ReportHeaderBar.buttonProperties)}
,isc.A.mouseOut=function isc_ReportHeaderBar_mouseOut(){if(this.cubeGrid.canHover)isc.Hover.clear();return isc.EventHandler.STOP_BUBBLING}
,isc.A.setButtons=function isc_ReportHeaderBar_setButtons(){if(this.cubeGrid.suppressInnerHeaders&&!this.vertical&&this.isInnerMost){this.addMember(isc.LayoutSpacer.create({width:this.cubeGrid.innerColFields.getProperty("width").sum()}));return}
if(this.baseConstructor==null){var _1=this.ID+"ButtonClass";this.baseConstructor=isc.ClassFactory.defineClass(_1,this.buttonConstructor);window[_1]=null;window.isc[_1]=null;this.baseConstructor.addProperties(this.buttonDefaults,this.buttonProperties)}
this.Super("setButtons",arguments);this.createSelection()}
,isc.A.$6h=function isc_ReportHeaderBar__makeItem(_1,_2){return this.baseConstructor.create({autoDraw:false},_1,_2)}
,isc.A.dragReorderMove=function isc_ReportHeaderBar_dragReorderMove(){var _1=this.dragStartPosition,_2=this.getDropPosition();this.dragCurrentPosition=_2;var _3=this.cubeGrid.getMoveGroupExtents(this.buttons,_1);var _4=this.members.duplicate();_2+=_3[0]-_1;_4.slideRange(_3[0],_3[1]+1,_2);this.stackMembers(_4,null,false);return isc.EH.STOP_BUBBLING}
,isc.A.getDropPosition=function isc_ReportHeaderBar_getDropPosition(){var _1=this.dragStartPosition,_2=this.Super("getDropPosition",arguments),_3=this.buttons[_1];if(_1==null||_3.parent==null)return _2;if(_3.moveGroup==null){return this.cubeGrid.nearestPositionWithinParent(this.buttons,_1,_2)}
var _4=this.cubeGrid.getMoveGroupDelta(this.buttons,_1,_2);return _1+_4}
,isc.A.createSelection=function isc_ReportHeaderBar_createSelection(){var _1=this.cubeGrid;var _2={data:this.members,simpleDeselect:(_1?_1.simpleDeselect:false),dragSelection:true};if(_1.rowHeaderGridMode&&!this.isFacetBar&&this.vertical){if(!_1.rowGridSelection){_2=isc.CellSelection.create(_2);_2.numCols=_1.rowFacets.length;_1.rowGridSelection=_2}
this.selection=_1.rowGridSelection;if(!this.isObserving(this.selection,"selectionChanged")){this.observe(this.selection,"selectionChanged","observer.cellSelectionChanged(observed.changedCells)")}}else{this.selection=isc.Selection.create(_2);this.observe(this.selection,"setSelected","observer.itemSelected()")}}
,isc.A.hitReorderHandle=function isc_ReportHeaderBar_hitReorderHandle(){var _1=isc.EH.lastEvent.nativeTarget;while(_1!=null){if(_1.getAttribute){var _2=_1.getAttribute("ID");if(_2&&_2.endsWith("reorderHandle"))return true}
_1=_1.parentNode}
return false}
,isc.A.rightMouseDown=function isc_ReportHeaderBar_rightMouseDown(){return this.itemMouseDown()}
,isc.A.itemMouseDown=function isc_ReportHeaderBar_itemMouseDown(){var _1=isc.EventHandler,_2=_1.getTarget();if(!this.hitReorderHandle()&&_1.dragOperation!="dragResize"&&_1.dragOperation!="dragResizeMember")
{if(this.isFacetBar&&this.cubeGrid.canMoveFacets){isc.EH.dragOperation="dragPivot";return isc.EH.stopBubbling}else if(this.canDragSelectItems){return this.startSelecting(_2)}}
return _1.STOP_BUBBLING}
,isc.A.startSelecting=function isc_ReportHeaderBar_startSelecting(_1){if(!this.cubeGrid.canSelectHeaders)return false;isc.EH.dragOperation="dragSelect";var _2=this.getButtonNumber(_1);if(_2<0)_2=this.getFocusButtonIndex();this.selection.selectOnMouseDown(this,_2,this.getEventColumn());this.selection.lastSelectionItem=this.getButton(_2);return isc.EH.stopBubbling}
,isc.A.itemMouseUp=function isc_ReportHeaderBar_itemMouseUp(){this.selection.selectOnMouseUp(this,this.getMouseOverButtonIndex(),this.getEventColumn())}
,isc.A.dragSelectStart=function isc_ReportHeaderBar_dragSelectStart(){this.dragStartPosition=this.getButtonNumber(isc.EH.dragTarget);return isc.EH.STOP_BUBBLING}
,isc.A.dragSelectMove=function isc_ReportHeaderBar_dragSelectMove(){if(!this.canDragSelectItems)return isc.EH.STOP_BUBBLING;var _1=this.cubeGrid,_2=this.selection.lastSelectionItem,_3=this.getMouseOverButtonIndex();if(this.isFacetBar){this.selection.selectOnDragMove(this,_3);return isc.EventHandler.STOP_BUBBLING}
var _4;if(_3>=0)_4=this.getButton(_3);else{_4=(_3==-1?this.members.first():this.members.last())}
var _5=this.cubeGrid.getHeaderSpan(_2),_6=this.cubeGrid.getHeaderSpan(_4);var _7,_8;if(_5[0]<_6[0]){_7=_5[1];_8=_6[1]}else{_7=_5[0];_8=_6[0]}
var _9=_1.findSelectionBoundary(_7,_8,this.selectionBoundaries),_10=_1.getHeadersForIndex(_9,_4.isRowHeader),_11=_10[_4.headerLevel],_9=this.getButtonNumber(_11);this.selection.selectOnDragMove(this,_9,this.getEventColumn());return isc.EventHandler.STOP_BUBBLING}
,isc.A.getEventColumn=function isc_ReportHeaderBar_getEventColumn(){if((this.isFacetBar&&this.vertical)||(!this.isFacetBar&&!this.vertical))return-1;var _1=this.cubeGrid,_2=_1.getOffsetX(),_3=_1.rowHeadersVisualOrder||_1.rowHeaders,_4=_3.map("getVisibleWidth"),_5=this.inWhichPosition(_4,_2);if(_5==-1)return 0;else if(_5==-2)return _3.length;return _5}
,isc.A.itemSelected=function isc_ReportHeaderBar_itemSelected(){if(this.isFacetBar&&this.vertical)return;this.updateButtonStyle();this.selectionChanged()}
,isc.A.selectionChanged=function isc_ReportHeaderBar_selectionChanged(){}
,isc.A.cellSelectionChanged=function isc_ReportHeaderBar_cellSelectionChanged(_1){var _2=this.cubeGrid.getFacetLocation(this.facetId).level,_3=false;for(var i=0;i<_1.length;i++){var _5=_1[i];if(_5[1]!=_2)continue;_3=true;var _6=this.getButton(_5[0]),_7=this.selection.cellIsSelected(_5[0],_5[1]);this.updateButtonStyle(_6,_7)}
if(_3)this.selectionChanged()}
,isc.A.updateButtonStyle=function isc_ReportHeaderBar_updateButtonStyle(_1,_2){_1=_1||this.selection.lastSelectionItem;var _3=this.getButtonNumber(_1);if(_1==null)return;if(_2==null)_2=this.selection.isSelected(_1);_1.setSelected(_2);_1.redrawIfDirty("header selection change")}
,isc.A.getSelection=function isc_ReportHeaderBar_getSelection(){return this.selection.getSelection()}
,isc.A.willAcceptDrop=function isc_ReportHeaderBar_willAcceptDrop(){if(!this.isFacetBar&&!this.vertical&&this.isInnerMost){return isc.EH.dragTarget.facetId!=null}
return this.Super("willAcceptDrop",arguments)}
,isc.A.dropOver=function isc_ReportHeaderBar_dropOver(){return false}
,isc.A.dropMove=function isc_ReportHeaderBar_dropMove(){if(!this.isFacetBar&&!this.vertical&&this.isInnerMost){var _1=this.cubeGrid;_1.showHDragLine(_1.getPageLeft()+_1.bodyOffsetX,this.getPageTop());return isc.EH.STOP_BUBBLING}
return this.Super("dropMove",arguments)}
,isc.A.drop=function isc_ReportHeaderBar_drop(){if(!this.isFacetBar&&!this.vertical&&this.isInnerMost){var _1=this.cubeGrid;_1.addFacet(isc.EH.dragTarget.facetId,false,_1.columnFacets.length-1);return isc.EH.STOP_BUBBLING}
return this.Super("drop",arguments)}
);isc.B._maxIndex=isc.C+24;isc.ClassFactory.defineClass("InnerHeader","Button");isc.A=isc.InnerHeader.getPrototype();isc.A.controlSize=13;isc.A.reorderHandleWidth=7;isc.A.closed=false;isc.A.redrawOnResize=true;isc.A.showFocused=false;isc.A.canDrag=true;isc.A.dragAppearance=isc.EventHandler.NONE;isc.A=isc.InnerHeader.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.useEventParts=false;isc.B.push(isc.A.initWidget=function isc_InnerHeader_initWidget(){var _1;var _2=this.cubeGrid;if(!_2.imgURLs){var _3=_2.imgURLs={reorderHandle:"[SKIN]header_handle.gif",minimize:"[SKIN]minimize.gif",maximize:"[SKIN]maximize.gif",sortDown:"[SKIN]sort_down.gif",sortDownSelected:"[SKIN]sort_down_selected.gif",sortUp:"[SKIN]sort_up.gif",sortUpSelected:"[SKIN]sort_up_selected.gif",closeBox:"[SKIN]close.gif"}
_2.imgTags={};for(var _4 in _2.imgURLs){var _5=(_4.endsWith("Selected")?_4.substring(0,_4.length-8):_4),_6=_2.controlLabels[_5];_2.imgTags[_4]=this.imgHTML(_3[_4],null,null,null," ALT='"+_6+"'"+" TITLE='"+_6+"'")}}
this.columnRef=this.facetId?this.facetId:this;this.isSorted=_2.$26r(this.columnRef);this.isSortedUp=this.isSorted&&_2.sortDirection==Array.ASCENDING;this.isSortedDown=this.isSorted&&_2.sortDirection==Array.DESCENDING;this.innerWidth=this.getWidth()-isc.Element.$yp(this.getStateName())}
,isc.A.getInnerHTML=function isc_InnerHeader_getInnerHTML(){var _1=isc.StringBuffer.create(),_2=this.cubeGrid,_3=this.getStateName();_1.append("<TABLE CELLSPACING=0 CELLPADDING=0 BORDER=0 STYLE='table-layout:fixed;",(this.cssText?this.cssText:""),"'"," WIDTH=",this.getWidth()," HEIGHT=",this.getHeight()," CLASS='",_3,"' ID=",this.getID(),"table><TR>");var _4=["<TD ID="+this.getID(),null," eventPart=",null," WIDTH=",null," HEIGHT="+this.controlSize," class=",_3,this.$4o,"'>",null,"</TD>"];if(this.minimized){_4[1]=_4[3]="maximize";_4[5]=this.controlSize;_4[11]=_2.imgTags.maximize;_1.append(_4)}else{if(this.showReorderHandle){_4[1]=_4[3]="reorderHandle";_4[5]=this.reorderHandleWidth;_4[11]=_2.imgTags.reorderHandle;_1.append(_4)}
if(this.showMinimize){_4[1]=_4[3]="minimize";_4[5]=this.controlSize;_4[11]=_2.imgTags.minimize;_1.append(_4)}
_4[1]=_4[3]="gap";_4[5]="*";_4[11]="&nbsp;";_1.append(_4);_4[5]=this.controlSize;if(this.showSortButtons){_4[1]=_4[3]="sortDown";_4[11]=this.isSortedDown?_2.imgTags.sortDownSelected:_2.imgTags.sortDown;_1.append(_4);_4[1]=_4[3]="sortUp";_4[11]=this.isSortedUp?_2.imgTags.sortUpSelected:_2.imgTags.sortUp;_1.append(_4)}
if(this.showCloseBox){_4[1]=_4[3]="closeBox";_4[11]=_2.imgTags.closeBox;_1.append(_4)}}
var _5=1+(this.showReorderHandle?1:0)+(this.showMinimize?1:0)+(this.showSortButtons?2:0)+(this.showCloseBox?1:0);_1.append("</TR><TR><TD COLSPAN=",_5," ALIGN=",this.align," VALIGN=",this.valign," HEIGHT=",this.getHeight()-this.controlSize," class=",_3,this.$4o,(this.wrap==false?"'><NOBR>":"'>"),this.getTitleHTML(),"</TD></TR></TABLE>");return _1.toString()}
,isc.A.getPreferredWidth=function isc_InnerHeader_getPreferredWidth(){var _1=isc.Canvas.create({contents:"<NOBR>"+this.getTitle()+"</NOBR>",className:this.getStateName(),width:1});var _2=_1.getScrollWidth()+(isc.Browser.isIE?2:0);_1.destroy();return _2}
,isc.A.stateChanged=function isc_InnerHeader_stateChanged(){var _1=isc.Element.get(this.getID()+"table");if(!_1)return;_1.className=this.getStateName()}
,isc.A.mouseMove=function isc_InnerHeader_mouseMove(){var _1=this.inWhichPart();if(_1!=this.lastPart){if(this.lastPart!=null)this.partMouseOut(this.lastPart);this.lastPart=_1;this.partMouseOver(_1)}}
,isc.A.mouseOut=function isc_InnerHeader_mouseOut(){if(isc.Browser.isUnix&&isc.Browser.isMoz&&this.containsEvent(isc.EventHandler.lastEvent)){return false}
if(this.lastPart){var _1=this.partMouseOut(this.lastPart);if(_1!=null)return _1}
return this.Super("mouseOut")}
,isc.A.partMouseOver=function isc_InnerHeader_partMouseOver(_1){this.setPartState(_1,"over");var _2=_1+"MouseOver";if(this[_2])return this[_2]()}
,isc.A.partMouseOut=function isc_InnerHeader_partMouseOut(_1){this.setPartState(_1,"");var _2=_1+"MouseOut";this.lastPart=null;if(this[_2])return this[_2]()}
,isc.A.mouseDown=function isc_InnerHeader_mouseDown(){if(this.lastPart)return this.partMouseDown(this.lastPart);return this.Super("mouseDown",arguments)}
,isc.A.partMouseDown=function isc_InnerHeader_partMouseDown(_1){var _2=_1+"MouseDown";if(this[_2])return this[_2]();this.setPartState(_1,"");return isc.EH.STOP_BUBBLING}
,isc.A.mouseUp=function isc_InnerHeader_mouseUp(){if(this.lastPart)return this.partMouseUp(this.lastPart);return this.Super("mouseUp",arguments)}
,isc.A.partMouseUp=function isc_InnerHeader_partMouseUp(_1){this.setPartState(_1,"over");return isc.EH.STOP_BUBBLING}
,isc.A.click=function isc_InnerHeader_click(){if(this.lastPart){var _1=this.lastPart+"Click";if(this[_1])return this[_1]()}
return this.Super("click")}
,isc.A.getEventPart=function isc_InnerHeader_getEventPart(){var _1=isc.EH.lastEvent.nativeTarget,_2=this.getHandle(),_3="eventPart";if(isc.Browser.isIE){while(_1!=null){if(_1.eventPart)return _1.eventPart;if(_1==_2)return null;_1=_1.parentElement}}
while(_1!=null){if(_1.eventPart!=null||(_1.hasAttribute!=null&&_1.hasAttribute(_3)))return _1.getAttribute(_3);if(_1==_2)return null;_1=_1.parentNode}}
,isc.A.inWhichPart=function isc_InnerHeader_inWhichPart(){var _1=this.getEventPart();if(_1==null)return"title";return _1}
,isc.A.setPartState=function isc_InnerHeader_setPartState(_1,_2){if(_1=="title"||_1=="gap")return;if(this.isSortedUp&&_1=="sortUp")_1+="$24l";if(this.isSortedDown&&_1=="sortDown")_1+="$24l";var _3=this.cubeGrid.imgURLs[_1];var _4=isc.Element.get(this.getID()+_1);if(_4==null)return;var _5=_4.firstChild;isc.Canvas.$wg(_5,this.getImgURL(isc.Img.urlForState(_3,false,false,_2)))}
,isc.A.minimizeClick=function isc_InnerHeader_minimizeClick(){this.cubeGrid.minimizeClick(this)}
,isc.A.maximizeClick=function isc_InnerHeader_maximizeClick(){this.cubeGrid.minimizeClick(this,false)}
,isc.A.sortDownClick=function isc_InnerHeader_sortDownClick(){this.cubeGrid.$26s(this.columnRef,Array.DESCENDING)}
,isc.A.sortUpClick=function isc_InnerHeader_sortUpClick(){this.cubeGrid.$26s(this.columnRef,Array.ASCENDING)}
,isc.A.closeBoxClick=function isc_InnerHeader_closeBoxClick(){this.closed=!this.closed;this.cubeGrid.$26t(this.columnRef,this.closed)}
,isc.A.getEventEdge=function isc_InnerHeader_getEventEdge(){var _1=this.Super("getEventEdge",arguments);if(_1==null)return null;if(this.showReorderHandle&&_1.contains("L")&&this.getOffsetY()<this.controlSize){return null}
return _1}
);isc.B._maxIndex=isc.C+22;isc.ClassFactory.defineInterface("Chart").addInterfaceMethods({valueProperty:"_value",stacked:false,chartType:"Column",threeD:true,animateValuesOnShow:true,labelValues:false,setupChart:function(){if(this.facets!=null&&!isc.isAn.Array(this.facets)){this.facets=[this.facets]}
this.inlinedFacet=this.facets.find("inlinedValues",true);for(var i=0;i<this.facets.length;i++){var _2=this.facets[i];if(!_2.values)this.deriveFacetValues(_2)}},deriveFacetValues:function(_1){if(_1.values)return;var _2=_1.id,_3=[];for(var i=0;i<this.data.getLength();i++){var _5=this.data.get(i)[_2];if(!_3.find("id",_5)){_3.add({id:_5,title:_5})}}
_1.values=_3},getFacet:function(_1){return this.facets.find("id",_1)},getFacetValue:function(_1,_2){var _3=this.getFacet(_1);if(_3)return _3.values.find("id",_2)},isMultiFacet:function(){return this.facets.length>1},getValue:function(_1){if(!isc.isAn.Array(this.data)){if(this.data==null)return null;var _2;for(var _3 in _1){_2=_1[_3]}
return this.data[_2]}
if(!this.inlinedFacet){var _4=this.data.find(_1);if(_4)return _4[this.valueProperty];return null}
var _5=_1[this.inlinedFacet.id],_6=isc.addProperties({},_1);delete _6[this.inlinedFacet.id];var _7=this.data.find(_6);if(!_7)return null;return _7[_5]},setData:function(){}});if(isc.Flashlet){isc.ClassFactory.defineClass("FusionChart","Flashlet","Chart");isc.A=isc.FusionChart;isc.A.allChartTypes=["Area","Bar","Column","Pie","Doughnut","Line","Radar"];isc.A.singleSeriesChartTypes=["Area","Bar","Column","Pie","Doughnut","Line"];isc.A.singleOnlyChartTypes=["Doughnut","Pie"];isc.A.multiSeriesChartTypes=["Area","Bar","Column","Line","Radar"];isc.A.multiOnlyChartTypes=["Radar"];isc.A.stackedChartTypes=["Area","Bar","Column"];isc.A.threeDChartTypes=["Column","Bar","Pie"];isc.A.needsDimension=["Column","Bar","Pie","Doughnut","Area"];isc.A=isc.FusionChart.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.overflow="hidden";isc.A.redrawOnResize=true;isc.A.chartsBaseURL=isc.Page.getIsomorphicDir()+"../FusionCharts/Charts/";isc.A.fusionVersion="3.0";isc.A.dataColors=["CCCCFF","CCCC99","FFCCCC","FFFF99","CCFF99","FFCC99","FF0000","00FF00","0000FF","FF00FF","FFFF00","00FFFF","000000"];isc.A.codeBase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0";isc.A.pluginsPage="http://www.macromedia.com/go/getflashplayer";isc.A.params={};isc.B.push(isc.A.getDataColor=function isc_FusionChart_getDataColor(_1){return this.dataColors[_1]||"FFFFFF"}
,isc.A.initWidget=function isc_FusionChart_initWidget(){this.Super("initWidget",arguments);this.setupChart();this.setChartProperties();this.$43w();this.setData()}
,isc.A.setSrc=function isc_FusionChart_setSrc(){if(this.chartURL){this.src=this.chartURL;return}
var _1=this.stacked&&isc.FusionChart.stackedChartTypes.contains(this.chartType);var _2,_3,_4=isc.FusionChart.needsDimension.contains(this.chartType);if(this.fusionVersion=="2.3"){_3="FC_2_3_";_2="Stckd";if(this.chartType=="Area"&&this.$43x){_2="Stkcd";_4=!_1}}else{_3="";_2="Stacked";if(this.chartType=="Area"&&this.$43x&&!_1){_4=false}}
var _5=isc.SB.create();_5.append(this.chartsBaseURL,_3,isc.FusionChart.multiOnlyChartTypes.contains(this.chartType)||(!this.$43x&&isc.FusionChart.singleSeriesChartTypes.contains(this.chartType))?"":_1?_2:"MS",this.chartType);if(_4){_5.append(this.threeD&&isc.FusionChart.threeDChartTypes.contains(this.chartType)&&!(this.fusionVersion=="2.3"&&this.chartType=="Bar")?"3D":"2D")}
_5.append(".swf")
this.src=_5.toString();this.logInfo("src set to: "+this.src)}
,isc.A.getInnerHTML=function isc_FusionChart_getInnerHTML(){this.setSrc();var _1=isc.SB.concat('&chartWidth=',this.getInnerWidth(),'&chartHeight=',this.getInnerHeight(),'&dataXML=',encodeURIComponent(this.getChartXML()));this.params.FlashVars=_1;return this.Super("getInnerHTML",arguments)}
,isc.A.getChartXML=function isc_FusionChart_getChartXML(){var _1=isc.SB.concat('<graph ',this.$263,'>',this.$264,this.$265,'</graph>');if(this.logIsDebugEnabled()){this.logWarn("chartXML: "+_1)}
return _1}
,isc.A.setChartProperties=function isc_FusionChart_setChartProperties(_1){if(!_1)_1=this.chartProperties;else this.chartProperties=_1;_1=isc.addProperties({caption:this.title,subCaption:this.subTitle,yAxisName:this.valueTitle,xAxisName:this.facets[0].title,animation:this.animateValuesOnShow,showValues:this.labelValues},this.chartProperties);var _2=isc.SB.create();for(var _3 in _1){if(_1[_3]===true){_2.append(_3,'="1" ')}else if(_1[_3]===false){_2.append(_3,'="0" ')}else if(_3.endsWith("olor")&&_1[_3].startsWith("#")){_2.append(_3,'="',_1[_3].substring(1),'" ')}else{_2.append(_3,'="',_1[_3],'" ')}}
this.$263=_2.toString();if(this.isDrawn())this.markForRedraw()}
,isc.A.$43w=function isc_FusionChart__generateCategoriesXML(_1){if(!_1)_1=this.facets[0].values;var _2=isc.SB.create();_2.append('<categories>');for(var i=0;i<_1.length;i++){if(_1[i].vLine){this.$768(_1[i],_2);continue}
_2.append('<category name="',isc.makeXMLSafe(_1[i].title||_1[i].id),'"');if(_1[i].longTitle){_2.append(' hoverText="',isc.makeXMLSafe(_1[i].longTitle),'"')}
if(_1[i].showTitle===false)_2.append(' showName="0"');_2.append('/>')}
_2.append('</categories>');this.$264=_2.toString();if(this.isDrawn())this.markForRedraw()}
,isc.A.$768=function isc_FusionChart__writeVLineXML(_1,_2){_2.append('<vLine');for(var _3 in _1){if(_3=="vLine")continue;_2.append(' ',_3,'="',isc.makeXMLSafe(_1[_3]),'"')}
_2.append('/>')}
,isc.A.setFacets=function isc_FusionChart_setFacets(_1){this.facets=_1;this.setupChart();this.$43w()}
,isc.A.setData=function isc_FusionChart_setData(_1,_2){var _1=this.data=_1||this.data;if(_1==null||(isc.isAn.Array(_1)&&_1.length==0)){return this.$265=""}
var _3=this.facets[0].values,_4=isc.SB.create();var _5=this.facets.first(),_6=_5.values,_7={};this.$43x=this.isMultiFacet();if(this.isMultiFacet()&&isc.FusionChart.singleOnlyChartTypes.contains(this.chartType))
{this.logWarn("'"+this.chartType+"' charts support one facet only;"+" showing only first value for second facet");this.$43x=false;_7[this.facets[1].id]=this.facets[1].values[0].id}
if(this.$43x){var _8=this.facets[1],_9=_8.values;var _10='<set value="',_11='"/>';for(var i=0;i<_9.length;i++){_4.append('<dataset seriesname="',isc.makeXMLSafe(_9[i].title),'" color="',this.getDataColor(i),'">');for(var j=0;j<_6.length;j++){if(_6[j].vLine)continue;_7[_8.id]=_9[i].id||_9[i].name;_7[_5.id]=_6[j].id||_6[j].name;_4.append(_10,this.getValue(_7),_11)}
_4.append("</dataset>")}}else{for(var i=0;i<_6.length;i++){if(_6[i].vLine){this.$768(_6[j],_4);continue}
_7[_5.id]=_6[i].id||_6[i].name;_4.append('<set value="',this.getValue(_7),'"');_4.append(' name="',isc.makeXMLSafe(_6[i].title||_6[i].id),'"');_4.append(' color="',this.getDataColor(i),'"');if(_6[i].longTitle){_4.append(' hoverText="',isc.makeXMLSafe(_6[i].longTitle),'"')}
if(_6[i].showTitle===false)_4.append(' showName="0"');_4.append('/>')}}
this.$265=_4.toString();if(this.isDrawn())this.markForRedraw()}
,isc.A.setChartType=function isc_FusionChart_setChartType(_1){if(!isc.FusionChart.allChartTypes.contains(_1)){this.logWarn("'"+_1+"' is not a recognized chart type")}else{_1=this.chartType=_1||this.chartType;this.setData();if(this.isDrawn())this.markForRedraw()}}
,isc.A.setFusionVersion=function isc_FusionChart_setFusionVersion(_1){this.fusionVersion=_1;this.setSrc();if(this.isDrawn())this.markForRedraw()}
,isc.A.setStacked=function isc_FusionChart_setStacked(_1){this.stacked=_1;if(_1&&!isc.FusionChart.stackedChartTypes.contains(this.chartType)){this.logWarn("'"+this.chartType+"' charts do not support stacking")}else{if(this.isDrawn())this.markForRedraw()}}
,isc.A.setThreeD=function isc_FusionChart_setThreeD(_1){if(_1&&!isc.FusionChart.threeDChartTypes.contains(this.chartType)){this.logWarn("'"+this.chartType+"' charts do not support 3D effects")}else{this.threeD=_1;if(this.isDrawn())this.markForRedraw()}}
);isc.B._maxIndex=isc.C+14}
if(isc.DrawPane){isc.ClassFactory.defineClass("BarChart","DrawPane","Chart");isc.A=isc.BarChart.getPrototype();isc.A.pixelsPerGradation=20;isc.A.scale=1;isc.A.defaultHeight=300;isc.A.defaultWidth=400;isc.A.chartType="Column";isc.A.canDrag=false;isc.A.cursor="auto";isc.A.styleName="scChart";isc.A.title="Chart";isc.A.valueAxisTitle="Value";isc.A.categoryAxis={title:"Category"};isc.A.vertical=true;isc.A.stacked=true;isc.A.contextMenu={data:[{dynamicTitle:"target.stacked ? 'Unstack' : 'Stack'",click:"target.setStacked(!target.stacked)"},{title:"Swap Facets",click:"target.swapFacets()"}]};isc.A.showLegend=true;isc.A.legendPosition=isc.Canvas.RIGHT;isc.A.overflow="hidden";isc.A.gradationLabelProperties={fontFamily:"Tahoma",fontSize:10,fontWeight:"normal",fontStyle:"normal"};isc.A.autoRotateLabels=true;isc.A.dataLabelProperties={fontFamily:"Tahoma",fontSize:10,rotation:90,fontWeight:"normal",fontStyle:"normal"};isc.A.legendLabelProperties={fontFamily:"Tahoma",fontSize:10,fontWeight:"normal",fontStyle:"normal"};isc.A.gradationLineProperties={lineWidth:1,lineColor:"#333333"};isc.A.barProperties={fillColor:"#FFCCCC",lineWidth:0,lineColor:"#333333"};isc.A.dataLineProperties={lineWidth:1,lineColor:"#333333",fillOpacity:0.5};isc.A.titleProperties={fontSize:16};isc.A.xGutter=30;isc.A.yGutter=80;isc.A.titleGutter=40;isc.A.padding=5;isc.A=isc.BarChart.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.redrawOnResize=true;isc.A.allContentAndChildren=true;isc.A.legendMarginTop=10;isc.A.chartRectMargin=5;isc.A.decimalPrecision=2;isc.A.chartMargin=10;isc.A.barMargin=20;isc.A.minBarThickness=4;isc.A.maxBarThickness=200;isc.A.clusterMargin=2;isc.A.titleMargin=5;isc.A.colorArray=["#FF3333","#33FF33","#3333FF","#33FFFF","#FFFF33","#FF33FF","#FF9933","#99FF33","#9933FF","#639966","#63CCCC","#6366FF","#800080","#999999","#FF00FF","#FFCC00","#00FF00","#00CCFF","#996366","#C0C0C0","#000000","#996100","#636300","#006300","#006366","#000080","#636399","#636363","#800000","#FF6600","#808000","#8000FF","#008080","#666699","#808080","#FF99CC","#FFCC99","#FFFF99","#CCFFCC","#CCFFFF","#99CCFF","#CC99FF","#FFFFFF"];isc.B.push(isc.A.initWidget=function isc_BarChart_initWidget(){this.$78f=this.padding;this.padding=0;this.Super("initWidget",arguments);this.setData(this.data)}
,isc.A.getMaxValue=function isc_BarChart_getMaxValue(_1){if(!_1&&this.maxValue!=null)return this.maxValue;var _2=this.getBarData();if(this.isMultiFacet()){var _3=0;for(var i=0;i<_2.getLength();i++){var _5=_2[i],_6,_7=_5.bars.getProperty("value");if(this.stacked){_6=_7.sum()}else{_6=_7.max()}
if(_6>_3)_3=_6}
this.maxValue=_3;return _3}else{return(this.maxValue=_2.getProperty("value").max())}}
,isc.A.$78g=function isc_BarChart__drawChartRect(){var _1=this.$78f+this.$78h.$78i.height+this.chartRectMargin,_2=this.$78f+this.$78j+this.chartRectMargin,_3=this.getInnerWidth()-_2-this.$78f,_4=this.getInnerHeight()-_1-this.$78f-
(this.$78k?this.$78k.height:0)-
this.barTitlesHeight-this.legendMarginTop-
this.chartRectMargin;this.$778={top:_1,left:_2,width:_3,height:_4}
this.drawRect(_2,_1,_3,_4,{lineWidth:1,lineColor:"black"})}
,isc.A.getChartRect=function isc_BarChart_getChartRect(){return this.$778}
,isc.A.draw=function isc_BarChart_draw(){this.Super("draw",arguments);this.drawChart()}
,isc.A.resized=function isc_BarChart_resized(){this.Super("resized",arguments);this.setData(this.data)}
,isc.A.setStacked=function isc_BarChart_setStacked(_1){this.stacked=!!_1;if(this.data)this.setData(this.data)}
,isc.A.swapFacets=function isc_BarChart_swapFacets(){if(this.facets){this.facets.reverse();if(this.data)this.setData(this.data)}}
,isc.A.setFacets=function isc_BarChart_setFacets(_1){this.facets=_1;this.setupChart()}
,isc.A.setData=function isc_BarChart_setData(_1){if(!_1)return;this.data=_1;this.setupChart();this.getBarData(true);this.getMaxValue(true);this.logInfo("setData: maxValue: "+this.maxValue);if(!this.isDrawn())return;this.erase();this.drawChart()}
,isc.A.getGradations=function isc_BarChart_getGradations(_1,_2){var _3=Math.round(_2/ this.pixelsPerGradation);var _4=_1>1?Math.round(_1).toString().length:-1*Math.round(1/_1).toString.length;var _5=Math.pow(10,_4-1),_6=Math.pow(10,(_4-2));var _7=[_6,2*_6,5*_6,10*_6,2*_5,5*_5];var _8,_9=Number.MAX_VALUE;for(var i=0;i<_7.length;i++){var _11=_7[i],_12=Math.ceil(_1/ _11),_13=Math.abs(_3-_12);if(_12<_3&&_13<_9){_8=_11;_9=_13}}
var _11=_8,_14=Math.ceil(_1/ _11)+1,_12=[];for(var i=0;i<_14;i++){_12[i]=i*_11}
var _15=_2/ _14;this.scale=_15/ _11;return _12}
,isc.A.drawChart=function isc_BarChart_drawChart(){this.drawTitle();if(this.isMultiFacet())this.drawLegend();if(!isc.isAn.Array(this.data)||this.data.length==0)return;this.$78j=this.drawGradationLabels();this.$78g();this.drawGradations(this.getGradationLines());this.drawData()}
,isc.A.getAllBarTitles=function isc_BarChart_getAllBarTitles(){var _1=this.getBarData();if(this.isMultiFacet()){return _1.getProperty("bars").getProperty("title")}else{return _1.getProperty("title")}}
,isc.A.drawGradationLabels=function isc_BarChart_drawGradationLabels(){if(this.autoRotateLabels){var _1=this.getAllBarTitles();this.barTitlesHeight=0;for(var i=0;i<_1.length;i++){var _3=this.measureLabel(_1[i],this.dataLabelProperties).width;this.barTitlesHeight=Math.max(this.barTitlesHeight,_3)}}else{this.barTitlesHeight=this.measureLabel("X",this.dataLabelProperties).height}
var _4=this.getInnerHeight()-(this.$78f*2)-
this.$78h.$78i.height-
(this.$78k?this.$78k.height:0)-
this.legendMarginTop-this.barTitlesHeight-this.chartRectMargin;this.gradations=this.getGradations(this.maxValue,_4);this.numGradations=this.gradations.length;var _5=0;var _1=this.gradations.duplicate().reverse();for(var i=0;i<_1.length;i++){var _6=(_4/(_1.length-1));var _7=Math.floor(i*_6)+this.$78f+this.$78h.$78i.height;var _8=this.drawLabel(this.$78f,_7-5,this.$779(_1[i]),this.gradationLabelProperties);var _9=this.measureLabel(this.$779(_1[i]),this.gradationLabelProperties);if(_9.width>_5)_5=_9.width}
return _5}
,isc.A.getFacetTitles=function isc_BarChart_getFacetTitles(){if(this.facets[0].values)return this.facets[0].values.getProperty("id");else return this.facets.getProperty("id")}
,isc.A.getGradationLines=function isc_BarChart_getGradationLines(){var _1=this.getChartRect(),_2=this.getFacetTitles(),_3=this.rowTitles=(this.vertical?this.gradations:_2),_4=this.colTitles=(this.vertical?_2:this.gradations),_5=this.rowHeight=Math.floor(_1.height/ _3.length),_6=this.colWidth=Math.floor(_1.width/ _4.length);var _7=[];var _8=this.gradations.duplicate().reverse();for(var i=0;i<_8.length;i++){var _10=(_1.height/(_8.length-1));var _11=Math.floor(i*_10)+_1.top;var _12=this.getInnerWidth()-this.$78f;_7.add({startPoint:[_1.left,_11],endPoint:[_12,_11]})}
return _7}
,isc.A.$779=function isc_BarChart__formatNumber(_1){return isc.Format.toUSString(_1)}
,isc.A.drawGradations=function isc_BarChart_drawGradations(_1){for(var i=0;i<_1.length;i++){var _3=_1[i];var _4=isc.DrawLine.create({drawPane:this,startPoint:_3.startPoint,endPoint:_3.endPoint,autoDraw:true},this.gradationLineProperties)}}
,isc.A.getBarData=function isc_BarChart_getBarData(_1){if(this.barData&&!_1)return this.barData;var _2=this.barData=[],_3=this.facets.first(),_4=_3.values,_5={};if(this.isMultiFacet()){var _6=this.facets[1],_7=_6.values;for(var i=0;i<_7.length;i++){var _9={};_9[_6.id]=_7[i].id;var _10={title:_7[i].title||_7[i].id,bars:[]}
_2.add(_10);for(var j=0;j<_4.length;j++){var _12=_4[j];var _13={title:_4[j].title||_4[j].id};_10.bars.add(_13);_9[_3.id]=_4[j].id;_13.value=parseFloat(this.getValue(_9))}}}else{var _9={};for(var i=0;i<_4.length;i++){var _12=_4[i];var _13={title:_4[i].title||_4[i].id};_2.add(_13);_9[_3.id]=_4[i].id;_13.value=parseFloat(this.getValue(_9))}}
return _2}
,isc.A.drawData=function isc_BarChart_drawData(){if(this.chartType=="Column"){this.drawBars()}else if(this.chartType=="Line"||this.chartType=="Area"){this.drawLines()}else{this.logWarn("chart type: '"+this.chartType+"' not supported")}}
,isc.A.drawLines=function isc_BarChart_drawLines(_1,_2,_3){_1=_1||this.getChartRect();_3=_3||this.getBarData();_2=_2||this.getMaxValue();if(this.isMultiFacet()){var _4=this.stacked||this.chartType=="Area";var _5=null;for(var i=0;i<_3[0].bars.length;i++){var _7=_3.getProperty("bars").getProperty(i).getProperty("value"),_8=this.getPoints(_1,_2,_7),_9=_8;if(_4){if(_5==null){_5=this.getBasePoints(_8)}else{this.addHeights(_8,_5)}
_9=_8.concat(_5.duplicate().reverse())}
_5=_8;var _10=this.getColor(i);var _11={lineColor:_10};this.drawDataLine(_8,_11);if(_4){_11.lineOpacity=0;_11.fillColor=_10;this.drawDataLine(_9,_11)}
if(i==0)this.drawLabelsUnder(_8.getProperty("0"),_3.getProperty("title"))}}else{var _7=_3.getProperty("value");var _8=this.getPoints(_1,_2,_7),_9=_8;var _10=this.getColor(0);var _11={lineColor:_10};if(this.chartType=="Area"){_11.fillColor=_10;_9=_8.concat(this.getBasePoints(_8).reverse())}
this.logWarn("points are: "+_8.getProperty("1"));this.drawDataLine(_9,_11);this.drawLabelsUnder(_8.getProperty("0"),_3.getProperty("title"))}}
,isc.A.getBasePoints=function isc_BarChart_getBasePoints(_1){var _2=this.getChartRect();var _3=[];for(var i=0;i<_1.length;i++){_3.add([_1[i][0],_2.top+_2.height])}
return _3}
,isc.A.addHeights=function isc_BarChart_addHeights(_1,_2){var _3=this.getChartRect();for(var i=0;i<_1.length;i++){_1[i][1]=_1[i][1]-(_3.height-(_2[i][1]-_3.top))}
return _1}
,isc.A.getPoints=function isc_BarChart_getPoints(_1,_2,_3){var _4=[],_5=this.chartMargin,_6=(_1.width-2*this.chartMargin),_7=Math.floor(_6/(_3.length-1)),_8=_6-(_7*(_3.length-1));_5+=Math.floor(_8/ 2);for(var i=0;i<_3.length;i++){var _10=_3[i],_11=_10/ _2;_4.add([_1.left+_5,_1.top+(_1.height-Math.round(_11*_1.height))]);_5+=_7}
return _4}
,isc.A.drawLabelsUnder=function isc_BarChart_drawLabelsUnder(_1,_2){for(var i=0;i<_1.length;i++){this.drawLabelUnder(_1[i],_2[i])}}
,isc.A.drawLabelUnder=function isc_BarChart_drawLabelUnder(_1,_2){var _3=this.$78r=this.$78r||this.measureLabel("X",this.dataLabelProperties).height;var _4=this.getChartRect().height+this.$78f+this.$78h.$78i.height+(this.chartRectMargin*2);var _5=_1;if(this.autoRotateLabels){if(isc.Browser.isIE){_5-=Math.floor(_3/ 2)}else{_5+=Math.floor(_3/ 2)}}else{var _6=this.measureLabel(_2,this.dataLabelProperties);_5=_5-(_6.width/ 2)}
this.drawLabel(_5,_4,_2,this.dataLabelProperties)}
,isc.A.drawBars=function isc_BarChart_drawBars(_1,_2,_3){_1=_1||this.getChartRect();_3=_3||this.getBarData();_2=_2||this.getMaxValue();var _4=this.isMultiFacet()&&this.stacked;var _5=this.isMultiFacet()&&!this.stacked;var _6=this.chartMargin;var _7=this.barMargin;var _8=this.isMultiFacet()?_3[0].bars.length:1;var _9=_5?_3.length*_8:_3.length;var _10=(_1.width-2*_6);var _11=(_3.length-1)*this.barMargin;var _12=_10-_11;var _13=Math.floor(_12/ _9);if(_5)_13+=this.clusterMargin;if(_13<this.minBarThickness){_13=this.minBarThickness}else if(_13>this.maxBarThickness){_13=this.maxBarThickness}
var _14=_5?((_13+this.clusterMargin)*_8):_13;_7=(_10-(_3.length*_14))/(_3.length-1);var _15=_14+_7;var _16=(_14*_3.length)+(_7*(_3.length-1))-_10;_6+=Math.round(_16/ 2);var _17=_4?0:this.clusterMargin;if(this.isMultiFacet()){for(var i=0;i<_3.length;i++){var _19=0;for(var j=0;j<_3[i].bars.length;j++){var _21=_3[i].bars[j];var _22=_21.value/ _2;var _23=Math.round(_22*_1.height);var _24=_1.left+_6+(i*_15);if(_5)_24+=(j*(_13+_17));var _25=_1.height+_1.top-_23-_19;if(_4)_19+=_23;var _26=isc.shallowClone(this.barProperties);_26.fillColor=this.getColor(j);this.drawRect(_24,_25,_13,_23,_26)}
var _24=_1.left+_6+(i*_15);var _27=_24+Math.floor(_14/ 2);this.drawLabelUnder(_27,_3[i].title)}}else if(this.isMultiFacet()){for(var i=0;i<_3.length;i++){for(var j=0;j<_3[i].bars.length;j++){var _21=_3[i].bars[j];var _22=_21.value/ _2;var _23=Math.round(_22*_1.height)}}}else{for(var i=0;i<_3.length;i++){var _22=1-(_3[i].value/ _2);var _24=(i*_15)+_1.left+_6;var _25=Math.round(_22*_1.height)+_1.top;var _23=_1.height-_25+_1.top;this.drawRect(_24,_25,_13,_23,this.barProperties);this.drawLabelUnder(Math.round(_24+(_13/ 2)),_3[i].title)}}}
,isc.A.drawRect=function isc_BarChart_drawRect(_1,_2,_3,_4,_5){var _6=isc.DrawRect.create({autoDraw:true,drawPane:this,left:_1,top:_2,width:_3,height:_4},_5);return _6}
,isc.A.drawDataLine=function isc_BarChart_drawDataLine(_1,_2){var _3=isc.DrawPath.create({drawPane:this,points:_1,autoDraw:true},this.dataLineProperties,_2);return _3}
,isc.A.drawTitle=function isc_BarChart_drawTitle(){var _1=this.measureLabel(this.title,this.titleProperties);var _2=Math.floor((this.getVisibleWidth()/2)-(_1.width/ 2));this.$78h=this.drawLabel(_2,this.$78f,this.title,this.titleProperties);this.$78h.$78i=_1}
,isc.A.drawLegend=function isc_BarChart_drawLegend(){var _1=20;var _2=5;var _3=5;var _4=5;var _5=5;var _6=this.facets[0];var _7=[];for(var i=0;i<_6.values.getLength();i++){var _9=_6.values[i];_7.add({title:_9.id})}
var _10=this.getInnerWidth()-(this.$78f*2);var _11=_2;var _12=1;for(var i=0;i<_7.length;i++){var _13=this.measureLabel(_7[i].title,this.legendLabelProperties);var _14=_1+_4+_13.width;if(_11+_14+_2>_10){_12++;_11=_2}
if(i!=_7.length-1){_14+=_3}
_7[i].width=_13.width;_7[i].height=_13.height;_7[i].rowNum=_12;_7[i].left=_11;_11+=_14}
_11+=_2;var _15,_16,_17,_18;if(_12>1){_18=_10;_16=(_12*_1)+(_2*2)+((_12-1)*_5)}else{_18=_11;_16=_1+(_2*2)}
_17=this.getInnerHeight()-_16-this.$78f;if(_18==_10)_15=this.$78f;else _15=Math.floor((_10/ 2)-(_18/ 2));this.$78k=this.drawRect(_15,_17,_18,_16);for(i=0;i<_7.length;i++){var _19=_7[i].width;var _11=_15+_7[i].left;var _20=_7[i].rowNum;var _21=_17+((_1+_5)*(_20-1))+_2;this.drawRect(_11,_21,_1,_1,{fillColor:this.getColor(i),lineWidth:1,lineColor:"black"});_11+=_1+_4;this.drawLabel(_11,_21,_7[i].title,this.legendLabelProperties)}}
,isc.A.getColor=function isc_BarChart_getColor(_1){return this.colorArray[_1%this.colorArray.length]}
,isc.A.drawLabel=function isc_BarChart_drawLabel(_1,_2,_3,_4){var _5=isc.DrawLabel.create({autoDraw:true,drawPane:this,left:_1,top:_2,contents:_3},_4);return _5}
,isc.A.measureLabel=function isc_BarChart_measureLabel(_1,_2){if(!_2)_2={};var _3=_2.fontFamily||isc.DrawLabel.getInstanceProperty('fontFamily'),_4=_2.fontWeight||isc.DrawLabel.getInstanceProperty('fontWeight'),_5=_2.fontSize||isc.DrawLabel.getInstanceProperty('fontSize'),_6=_2.fontStyle||isc.DrawLabel.getInstanceProperty('fontStyle');if(!this.$78l){this.$78l=isc.Canvas.create({top:-1000,overflow:"visible",autoDraw:true,height:1,width:1})}
var _7="font-family:"+_3+";font-weight:"+_4+";font-size:"+_5+"px;font-style:"+_6+";white-space:nowrap";this.$78l.setContents("<span style='"+_7+"'>"+_1+"</span>");this.$78l.redraw();var _8={width:this.$78l.getVisibleWidth(),height:this.$78l.getVisibleHeight()};return _8}
);isc.B._maxIndex=isc.C+34}
isc.A=isc.CubeGrid.getPrototype();isc.B=isc._allFuncs;isc.C=isc.B._maxIndex;isc.D=isc._funcClasses;isc.D[isc.C]=isc.A.Class;isc.A.waiRole="grid";isc.A.rowRole=null;isc.A.cellRole="gridCell";isc.B.push(isc.A.getCellWAIState=function isc_CubeGrid_getCellWAIState(_1,_2){var _3=this.getCellRecord(_1,_2);if(this.selection&&this.selection.cellIsSelected(_1,_2)){return{selected:true}}}
);isc.B._maxIndex=isc.C+1;isc._moduleEnd=isc._Analytics_end=(isc.timestamp?isc.timestamp():new Date().getTime());if(isc.Log&&isc.Log.logIsInfoEnabled('loadTime'))isc.Log.logInfo('Analytics module init time: ' + (isc._moduleEnd-isc._moduleStart) + 'ms','loadTime');delete isc.definingFramework;}else{if(window.isc && isc.Log && isc.Log.logWarn)isc.Log.logWarn("Duplicate load of module 'Analytics'.");}

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

