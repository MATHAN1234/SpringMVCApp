<h3>${Name}</h3>
<h1> Product Meta Search Engine </h1><br /><br />
<div>
    <form method="get" action="/SpringMVCApp_war_exploded/Search">
        <div class="input-group mb-3 wid-80">
            <input class="form-control" type="text" name="query" value="${searchString}" placeholder="Enter a Product Name..." />
            <div class="input-group-prepend">
                <input class="btn btn-secondary btn-sm" type="submit" value="Search" />
            </div>
        </div>

    </form>

    <br /><br /><br /><br />
    <div class="">
        <div class="row"><c:forEach items="${Items}" var="item">
            <div class="product-grid-item col col-lg-3 col-md-4 col-sm-6 col-xs-12 m-b-15">
                <a href="${item.url}"></a>
                <img src="${item.image}" />
                <p class="m-b-5"><small>${item.source}</small></p>
                <h6 class="m-t-0">${item.title}</h6>
                <p><strong>RM${item.price}</strong></p>
            </div>

        </c:forEach>
        </div>
    </div>
