<!DOCTYPE html>
<html>
<#include "./include/head.ftl">
<body>
<#include "./include/support.ftl">
<#include "./include/header.ftl">
<div class="g-doc">
    <div>
        <h3>ERROR!</h3>
        <p/>
        <#if error=="001" || error=="002" || error=="003">
            ${error!"Unknown error..."}, please <a href="login.ftl"></a>
        </#if>
    </div>
</div>
<#include "./include/footer.ftl">
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageIndex.js"></script>
</body>
</html>