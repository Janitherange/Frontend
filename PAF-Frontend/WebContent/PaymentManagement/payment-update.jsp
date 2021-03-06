<%@ page import="connection.PaymentConnection" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
Statement statement = null;
	ResultSet resultSet = null;	

	PaymentConnection paymentConnection = new PaymentConnection();
%>

<!doctype html>
<html>
   <head>
       <meta charset='utf-8'>
       <meta name='viewport' content='width=device-width, initial-scale=1'>
       <title>Update Payment Method</title>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
       
       <link rel="stylesheet" href="../css/product-list.css">
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
	   <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
	   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
	   
       <script type='text/javascript' src='../js/set-image.js'></script>
   </head>
   <body oncontextmenu='return false' class='snippet-body'>
       <div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
    	  <div class="cad card0 border-0">
        	 <div class="row d-flex">
             	<div class="col-lg-2">
                	<div class="card1 pb-5">
                    	<div class="col  justify-content-center mt-4 mb-5 border-line"> 
                    		<a id="home-button" href="/PAF-Frontend/Usermanagemnt/Customer/home-customer.jsp">
                    			<img src="../images/homepage.svg" class="image">Home
                    		</a>
                    		<div class="mt-5 ">
                    			<button type="button" class="btn btn-blue text-center menu" onClick="location.href ='/PAF-Frontend/OrderManagement/order-list.jsp'">Order Management</button> 
                    			<button type="button" class="btn btn-blue text-center menu" >Payment Management</button>
                    		</div>
                    		<img src="../images/undraw_Marketing_re_7f1g.svg" class="image2">
                    	</div>
                	</div>
            	</div>
            	<div class="col-lg-10">
                	<div class="card2 card border-0 px-4 py-5">
                		<div class="row mb-4 px-3">
                			<h1 class="mb-5 mr-4 mt-2 left" style="margin-left: -24px;">Update payment Method</h1>
                				<div class="row mb-3 px-3"> 
                    				<button type="button" class="btn btn-blue text-center" onClick="location.href ='/PAF-Frontend/PaymentManagement/payment-list.jsp'">
                    					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
  											<path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
										</svg> Back								
									</button> 
                    			</div>
								<form class="row g-3 needs-validation" action="<%= request.getContextPath() %>/PaymentUpdateApi" method="post" novalidate >
								<%
								
									Connection connect = paymentConnection.getConnection();
									statement=connect.createStatement();
									
									int cardID = Integer.parseInt(request.getParameter("cardID"));	
									
									String sql ="select * from payment where cardID ="+ cardID;
									resultSet = statement.executeQuery(sql);
									while(resultSet.next())
									{
								%>
									<div class="col-md-12">
											<div class="row px-3"> 
                							<label class="mb-1 ">
                								<h6 class="mb-0 text-sm">Card Type</h6>
                							</label>
                							<input type="hidden" id="cardID" name="cardID" value='<%=resultSet.getString("cardID") %>'>
                							<input class="mb-4 px-3 form-control" type="text" id="cardType" name="cardType" placeholder="Enter the Card Type"  value='<%=resultSet.getString("cardType") %>' required> 
                							<div class="valid-feedback message">Valid</div>
                							<div class="invalid-feedback message">Name shouldn't be empty</div>
										</div>
									</div>
									<div class="col-md-6">
                							<div class="row px-3"> 
                							<label class="mb-1 ">
                								<h6 class="mb-0 text-sm">Card Number</h6>
                							</label>
                							<input class="mb-4 px-3 form-control" type="text" id="cardNumber" name="cardNumber" placeholder="Enter the Card Number" value='<%=resultSet.getString("cardNumber") %>'  required> 
                							<div class="valid-feedback message">Valid</div>
                							<div class="invalid-feedback message">Name shouldn't be empty</div>
                        				</div>
                					</div>
                        			<div class="col-md-6">	
                        				<div class="row px-3"> 
                							<label class="mb-1 ">
                								<h6 class="mb-0 text-sm">Expire Date</h6>
                							</label>
                							<input class="mb-4 px-3 form-control" type="text" id="expireDate" name="expireDate" placeholder="Enter the Expire Date" value='<%=resultSet.getString("expireDate") %>'  required> 
                							<div class="valid-feedback message">Valid</div>
                							<div class="invalid-feedback message">Name shouldn't be empty</div>
                        				</div>
                        			</div>	
                        			<div class="col-md-12">
                        				<div class="row px-3"> 
                							<label class="mb-1 ">
                								<h6 class="mb-0 text-sm">CVC</h6>
                							</label>
                							<input class="mb-4 px-3 form-control" type="text" id="cvc" name="cvc" placeholder="Enter the cvc" value='<%=resultSet.getString("cvc") %>' required> 
                							<div class="valid-feedback message">Valid</div>
                							<div class="invalid-feedback message">Name shouldn't be empty</div>
                        				</div>
                        			</div>
                					<div class="col-md-12">
										<div class="row mb-3 px-3"> 
											<div class="col-md-6">
												<button type="submit" class="btn btn-blue text-center">Update</button> 
												<button type="reset" class="btn btn-red text-center">Reset</button> 
											</div>
                    					</div>
                    				</div>
                    				<%
                    				
									}	
									connect.close();	
									
                    				%>
								</form>
                			</div>
            			</div>
        	 		</div>
      	  		</div>
   	   		</div>
   	 	</div>
   	   	<script type="text/javascript">
   			var forms=document.querySelectorAll(".needs-validation");
			Array.prototype.slice.call(forms).forEach(function(form)
			{
				form.addEventListener("submit", function(event)
				{
					if(!form.checkValidity())
					{
						event.preventDefault();
						event.stopPropagation();
					}
				
				form.classList.add("was-validated");
				}, false);
			});
   	   </script>
   </body>
</html>
