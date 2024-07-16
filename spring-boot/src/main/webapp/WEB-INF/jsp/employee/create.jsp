<jsp:include page="../include/header.jsp" />


<section style="background-color:mediumpurple">
    <div class="container">
        <div class = "row pt-5 pb-5">
            <div class="text-center">
                <h1>Create Employee</h1>
            </div>
        </div>
    </div>
</section>


<section>
    <div class="container">
        <div class="row pt-5 ">
            <div class="col-12">
                <form action="/employee/createSubmit">
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="emailId" class="col-form-label">Email</label>
                            <%--                            the for label has to match the id--%>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="emailId" name="email" class="form-control">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="firstNameId" class="col-form-label">First Name</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="firstNameId" name="firstName" class="form-control">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="lastNameId" class="col-form-label">Last Name</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="lastNameId" name="lastName" class="form-control">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="extensionId" class="col-form-label">Extension</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="extensionId" name="extension" class="form-control">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="jobTitleId" class="col-form-label">Job Title</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="jobTitleId" name="jobTitle" class="form-control">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="vacationHoursId" class="col-form-label">Vacation Hours</label>
                        </div>
                        <div class="col-auto">
                            <input type="number" id="vacationHoursId" name="vacationHours" class="form-control">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="profileImageUrlId" class="col-form-label">Profile Image URL</label>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="profileImageUrlId" name="profileImageUrl" class="form-control">
                        </div>
                    </div>
                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="reportsTo" class="col-form-label">Reports To</label>
                        </div>
                        <div class="col-4">
                            <select id="reportsTo" name="reportsTo" class="form-control">
                                <c:forEach items="${reportsToEmployees}" var="employee">
                                    <option value="${employee.id}">${employee.firstname} ${employee.lastname}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="row align-items-center justify-content-center pb-3">
                        <div class="col-2">
                            <label for="reportsToOffices" class="col-form-label">Reports To Office</label>
                        </div>
                        <div class="col-4">
                            <%--                            the name has to match the field in the bean --%>
                            <select id="reportsToOffices" name="officeId" class="form-control">
                                <c:forEach items="${reportsToOffices}" var="office">
                                    <option value="${office.id}">${office.city}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row justify-content-center ">
                        <div class="col-auto text-center">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp" />


<!-- >step 1 create jsp, 2 add to controller -->