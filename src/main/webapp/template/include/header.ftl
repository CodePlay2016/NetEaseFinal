<div class="n-head">
    <div class="g-doc f-cb">
        <div class="person">
        <#if person??>
            <#--这里的userType的T一定要大写，他才能找到对应的getter方法。如果不改这边的话可以把meta里的getUserType改为getUsertype-->
            <#if person.userType==1>卖家<#else>买家</#if>你好，<span class="name">${person.userName}</span>！<a href="/logout">[退出]</a>
        <#else>
            请<a href="/login">[登录]</a>
        </#if>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
            <#if person?? && person.userType==0>
            <li><a href="/account?id=${person.userId}">账务</a></li>
            <li><a href="/settleAccount">购物车</a></li>
            </#if>
            <#if person?? && person.userType==1>
            <li><a href="/public">发布</a></li>
            </#if>
        </ul>
    </div>
</div>