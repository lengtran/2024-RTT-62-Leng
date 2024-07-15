<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Customer Details</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-6">
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <td>${customer.id}</td>
                    </tr>
                    <tr>
                        <th>Customer Name</th>
                        <td>${customer.customerName}</td>
                    </tr>
                    <tr>
                        <th>Contact Name</th>
                        <td>${customer.contactFirstname} ${customer.contactLastname}</td>
                    </tr>
                    <tr>
                        <th>Phone</th>
                        <td>${customer.phone}</td>
                    </tr>
                    <tr>
                        <th>Address</th>
                        <td>${customer.addressLine1}, ${customer.addressLine2}, ${customer.city}, ${customer.state}, ${customer.postalCode}, ${customer.country}</td>
                    </tr>
                    <tr>
                        <th>Credit Limit</th>
                        <td>${customer.creditLimit}</td>
                    </tr>
                </table>
            </div>
        </div>

        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Orders</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Order Date</th>
                        <th>Required Date</th>
                        <th>Status</th>
                        <th>Comments</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td>${order.id}</td>
                            <td>${order.orderDate}</td>
                            <td>${order.requiredDate}</td>
                            <td>${order.status}</td>
                            <td>${order.comment}</td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />
