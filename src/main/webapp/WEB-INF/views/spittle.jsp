<c:forEach items="${spittleList}" var="spittle">
    <li id="spittle_<c:out value="spittle.id"/>">
        <div class="spittleMessage">
            <c:out value="${spittle.message}"/>
        </div>
        <div class="spittleView">
            <div class="spittleMessage"><c:out value="${spittle.message}"/></div>
            <div>
                <span class="spittleTime"><c:out value="${spittle.time}"/></span>
            </div>
        </div>
    </li>
</c:forEach>