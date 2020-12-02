<#import "parts/common.ftlh" as c>

<@c.page>
    <h5>${user.username}</h5>
    <div>${message!}</div>
    <form method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password: </label>
        <div class="col-sm-6">
            <input type="password" name="password" placeholder="Password" class="form-control"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Email: </label>
        <div class="col-sm-6">
            <input type="email" name="email" value="${user.email!''}" placeholder="some@some.com" class="form-control"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary mb-3">Save</button>
</@c.page>