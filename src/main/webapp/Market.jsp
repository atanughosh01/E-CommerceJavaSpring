<%@page import="java.sql.Time" %>
	<%@ page import="java.util.List, SpringDB.schema.* " language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="ISO-8859-1">
			<title>Clothify</title>
			<style type="text/css">
				body {
					text-align: center !important;
					background-color: #e6ecb4 !important;
				}

				#apparel-card-outer {
					width: 100%;
					display: flex;
					justify-content: space-around;
					flex-wrap: wrap;
				}

				#apparel-card {
					width: 30%;
					margin: 0.5rem;
				}

				#filter {
					padding: 1rem;
					margin: 1rem !important;
				}

				#search {
					margin-right: 2rem !important;
				}
			</style>
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
				crossorigin="anonymous">
		</head>

		<body>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<div class="container-fluid">
					<a class="navbar-brand" href="http://localhost:8080/home">Clothify</a>
					<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
						data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item">
								<a class="nav-link active" aria-current="page" href="#">Home</a>
							</li>
							<li class="nav-item">
								<a class="nav-link active" aria-current="page" href="/user/purchases">Purchases</a>
							</li>
							<li class="nav-item">
								<a class="nav-link disabled">Disabled</a>
							</li>
						</ul>
						<form action="/user/Search" id="search" class="d-flex" method="get">
							<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
								name="search">
							<button class="btn btn-outline-success" type="submit">Search</button>
						</form>
						<form class="d-flex" action="/logout">
							<button class="btn btn-outline-success" type="submit">Log Out</button>
						</form>
					</div>
				</div>
			</nav>
			<form id="filter" action="/user/Sort" method="get">
				Price:
				<select name="order">
					<option value="ASC">Ascending</option>
					<option value="DESC">Descending</option>
				</select>
				<button type="submit" class="btn btn-info">Submit</button>
			</form>
			<div id="apparel-card-outer">
				<% List<Apparel> arr=(List<Apparel>)request.getAttribute("apparels");
						int num=1;
						for(Apparel a:arr){
						%>
						<% if(a.getType().equals("New")){ %>
							<div id="apparel-card" class="card" style="width: 18rem;background-color:#73d5f3;">
								<div class="card-body">
									<h5 class="card-title">Apparel <%= num %>
									</h5>
									<h5 class="card-subtitle mb-2 text-muted">Brand:&nbsp;<%= a.getBrand() %>
									</h5>
									<h6 class="card-subtitle mb-2 text-muted">Category:&nbsp;<%= a.getCategory() %>
									</h6>
									<p class="card-text"><b>Price: </b>
										<%= a.getPrice() %>
									</p>
									<p class="card-text"><b>Gender: </b>
										<%= a.getGender() %>
									</p>
									<p class="card-text"><b>Type: </b>
										<%= a.getType() %>
									</p>
									<div class="card-body">
										<button class="btn btn-success"><a
												href="/user/buy?id=<%= a.getAid() %>">Buy</a></button>
									</div>

								</div>
							</div>
							<% } else{ %>
								<div id="apparel-card" class="card" style="width: 18rem;background-color:#eec2d4;">
									<div class="card-body">
										<h5 class="card-title">Apparel <%= num %>
										</h5>
										<h5 class="card-subtitle mb-2 text-muted">Brand:&nbsp;<%= a.getBrand() %>
										</h5>
										<h6 class="card-subtitle mb-2 text-muted">Category:&nbsp;<%= a.getCategory() %>
										</h6>
										<p class="card-text"><b>Price: </b>
											<%= a.getPrice() %>
										</p>
										<p class="card-text"><b>Gender: </b>
											<%= a.getGender() %>
										</p>
										<p class="card-text"><b>Type: </b>
											<%= a.getType() %>
										</p>
										<div class="card-body">
											<button class="btn btn-success"><a
													href="/user/buy?id=<%= a.getAid() %>">Buy</a></button>
										</div>
									</div>
								</div>
								<% } %>
									<% num++; %>
										<% } %>
			</div>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
				crossorigin="anonymous"></script>
		</body>

		</html>