<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">User Name : </label>
            <div class="col-sm-6">
                <input type="text" name="username" placeholder="Username" class="form-control"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password: </label>
            <div class="col-sm-6">
                <input type="password" name="password" placeholder="Password" class="form-control"/>
            </div>
        </div>
        <#if isRegisterForm>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Email: </label>
            <div class="col-sm-6">
                <input type="email" name="email" placeholder="some@some.com" class="form-control"/>
            </div>
        </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary mb-3"><#if isRegisterForm>Create<#else>Sign in</#if></button>
        <#if !isRegisterForm>
            <div><a href="/registration">Add new user</a></div>
        </#if>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Logout</button>
    </form>
</#macro>