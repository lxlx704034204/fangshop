<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="系统设置">
<style>
      .font-focus{
          font-weight: 700;font-size: 16px;color: #f50 !important;text-decoration: underline;
      }
    .mystyle{
        background-color:#1c94c4 !important;
    }
</style>
<div>
<div style="text-align: center;margin-bottom: 10px;"><button type="button" id="btnSave"  class="btn btn-success">保存</button></div>
<div id="tabs">
    <ul>
        <li><a href="#tabs-1">基本设置</a></li>
        <li><a href="#tabs-2">图片设置</a></li>
        <li><a href="#tabs-3">样式设置</a></li>
        <li><a href="#tabs-4">QQ店小二设置</a></li>
        <li><a href="#tabs-5">图集</a></li>
    </ul>
    <div id="tabs-1">
        <table class="table table-condensed">
            <tr>
                <td style="text-align: right;width: 100px">系统版本</td>
                <td style="text-align: left;"><input type="text" name="version" value="${systemSetting.version!""}" id="version" data-rule="required;version;length[0~100];"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;width: 100px">系统代号</td>
                <td style="text-align: left;"><input type="text"  name="systemCode" value="${systemSetting.systemCode!""}"
                                                     id="systemCode" data-rule="required;systemCode;length[1~30];"/></td>
            </tr>
            <tr>
                <td style="text-align: right;width: 100px">名称</td>
                <td style="text-align: left;"><input type="text"  name="name" value="${systemSetting.name!""}"
                                                     id="name" data-rule="required;name;length[1~30];"/></td>
            </tr>
            <tr>
                <td style="text-align: right;">门户地址</td>
                <td style="text-align: left;"><input type="text"  name="www" size="100" value="${systemSetting.www!""}"
                                                     id="www" data-rule="required;www;length[1~100];"/></td>
            </tr>
            <tr>
                <td style="text-align: right;">后台地址</td>
                <td style="text-align: left;"><input type="text"  name="manageHttp" size="100"  value="${systemSetting.manageHttp!""}"
                                                     id="manageHttp" data-rule="required;manageHttp;length[1~100];"/></td>
            </tr>
            <tr>
                <td style="text-align: right;">log</td>
                <td style="text-align: left;"><input type="text"  name="log"  value="${systemSetting.log!""}"
                                                     id="log" data-rule="required;log;length[0~100];"/></td>
            </tr>
            <tr>
                <td style="text-align: right;">网站标题</td>
                <td style="text-align: left;"><input type="text"  name="title"  value="${systemSetting.title!""}"
                                                     id="title" data-rule="required;title;length[0~100];"/></td>
            </tr>
            <tr>
                <td style="text-align: right;">description</td>
                <td style="text-align: left;">
                    <input type="text"  id="description" name="description" value="${systemSetting.description!""}" data-rule="required;description;length[0~100];"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">keywords</td>
                <td style="text-align: left;">
                    <input type="text"  id="keywords" name="keywords" value="${systemSetting.keywords!""}" data-rule="required;keywords;length[0~100];"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">shortcuticon</td>
                <td style="text-align: left;">
                    <input type="text"  id="shortcuticon" name="shortcuticon" value="${systemSetting.shortcuticon!""}" data-rule="required;shortcuticon;length[0~100];"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">联系地址</td>
                <td style="text-align: left;">
                    <input type="text"  id="address" name="address" value="${systemSetting.address!""}" data-rule="required;address;length[0~100];"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">联系电话</td>
                <td style="text-align: left;">
                    <input type="text"  id="tel" name="tel"  value="${systemSetting.tel!""}"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">邮箱</td>
                <td style="text-align: left;">
                    <input type="text"  id="email" name="email" value="${systemSetting.email!""}" data-rule="required;email;length[0~100];"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">备案号</td>
                <td style="text-align: left;">
                    <input type="text"  id="icp" name="icp"  value="${systemSetting.icp!""}" data-rule="required;icp;length[0~100];"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">站长统计代码</td>
                <td style="text-align: left;">
                    <textarea id="statisticsCode" cols="100" rows="6" name="statisticsCode" data-rule="required;statisticsCode;length[10~1000];">${systemSetting.statisticsCode!""}</textarea>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">是否开放网站</td>
                <td style="text-align: left;">
                    <input type="checkbox" id="isopen" name="isopen" value="true" <#if (systemSetting.isopen)?? && systemSetting.isopen=="true">checked="checked"</#if> />
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">关闭信息</td>
                <td style="text-align: left;">
                    <textarea id="closeMsg" name="closeMsg" cols="100" rows="6">${systemSetting.closeMsg!""}</textarea>
                </td>
            </tr>
        </table>
    </div>
    <div id="tabs-2">
        <table class="table table-condensed">
            <tr>
                <td style="text-align: right;width: 100px">是否启用响应式</td>
                <td style="text-align: left;">
                    <#assign y_n = {'y':'启用','n':'禁用'}>
                    <select id="unit" name="openResponsive">
                        <#--<#list y_n?keys as key>-->
                            <#--<option value="${key}" <#if e.openResponsive?? && e.openResponsive==key>selected="selected" </#if>>${y_n[key]}</option>-->
                        <#--</#list>-->
                    </select>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;width: 100px">图片根路径</td>
                <td style="text-align: left;"><input type="text"  name="imageRootPath"  value="${systemSetting.imageRootPath!""}"
                                                     id="imageRootPath" data-rule="required;imageRootPath;length[0~100];"/></td>
            </tr>
            <tr>
                <td style="text-align: right;">产品默认图片</td>
                <td style="text-align: left;"><input type="text"  name="defaultProductImg"  value="${systemSetting.defaultProductImg!""}"
                                                     id="defaultProductImg" data-rule="required;defaultProductImg;length[0~100];"/></td>
            </tr>
            <tr>
                <td style="text-align: right;width: 100px">后台左侧菜单叶子节点的图标</td>
                <td style="text-align: left;"><input type="text"  name="manageLeftTreeLeafIcon"  value="${systemSetting.manageLeftTreeLeafIcon!""}"
                                                     id="manageLeftTreeLeafIcon" data-rule="required;manageLeftTreeLeafIcon;length[0~100];"/></td>
            </tr>
        </table>
    </div>
    <div id="tabs-3">
        <table class="table table-condensed">
            <tr>
                <td style="text-align: right;">选择样式</td>
                <td style="text-align: left;">
                    <#assign styles = {'amelia':'amelia','cerulean':'cerulean','cosmo':'cosmo','cyborg':'cyborg','default':'default','flatly':'flatly','journal':'journal','readable':'readable','simplex':'simplex','slate':'slate','spacelab':'spacelab','united':'united','yeti':'yeti'}>
                    <select id="style" name="style" class="input-medium" onchange="changeStyle()" >
                        <#list styles?keys as key>
                            <option value="${key}" <#if systemSetting.style?? && systemSetting.style==key>selected="selected" </#if>>${styles[key]}</option>
                        </#list>
                    </select>
                    <br>
                    <a id="ceshiA" target="_blank">
                        <img alt="" src="" id="styleImg" style="border: 1px solid #aaa;" >
                    </a>
                </td>
            </tr>
        </table>
    </div>
    <div id="tabs-4">
        <table class="table table-bordered">
            <tr>
                <td style="text-align: left;" colspan="2">
                    <div class="alert alert-info">
                        请在下面填写站点客服的QQ组建HTML内容。可以从QQ的网站(http://connect.qq.com/intro/wpa)上取得HTML内容。号码和内容描述可以自己修改。
                    </div>
                    <textarea name="qqHelpHtml" style="width:100%;height:200px;visibility:hidden;">${systemSetting.qqHelpHtml!""}</textarea>
                </td>
            </tr>
        </table>
    </div>
    <div id="tabs-5">
        <div>
            <div class="alert alert-info">图集：如果广告位的属性设置为图集随机优先，则广告位的位置会优先选择显示图集中的图片。选择图片的方式为随机选取。</div>
            <table class="table table-bordered">
                <tr>
                    <td colspan="11">
                        <input style="display: none;" onclick="addTrFunc();" value="添加" class="btn btn-warning" type="button"/>
                        <button method="deleteImageByImgPaths" onclick="return deleteImageByImgPaths(this);"
                                class="btn btn-primary">删除</button>

                    </td>
                </tr>
                <tr style="background-color: #dff0d8">
                    <th width="50"><input type="checkbox" id="firstCheckbox" /></th>
                    <th>图片地址</th>
                </tr>
                <#--<#list systemSetting.imagesList as img>-->
                    <#--<tr>-->
                        <#--<td><input type="checkbox" name="imagePaths"-->
                                   <#--value="${img}" /></td>-->
                        <#--<td>-->
                            <#--<a href="${systemSetting().imageRootPath}/${img}" target="_blank">-->
                                <#--<img style="max-width: 100px;max-height: 100px;" alt="" src="${systemSetting().imageRootPath}/${img}">-->
                            <#--</a>-->
                        <#--</td>-->
                    <#--</tr>-->
                <#--</#list>-->
            </table>
        </div>
        <br>
        <table class="table table-bordered">
            <tr style="background-color: #dff0d8">
                <td>文件</td>
            </tr>
            <tr id="firstTr">
                <td>
                    <#list [0..10] as item>
                        <div>
                            <input type="button" name="filemanager" value="浏览图片" class="btn btn-warning"/>
                            <input type="text" ccc="imagesInput" name="images" style="width: 80%;" />
                        </div>
                    </#list>
                </td>
            </tr>
        </table>
    </div>
</div>
</div>
<script type="text/javascript">
    $(function(){
        $("#tabs").tabs();
    });
</script>
</@page.pageBase>