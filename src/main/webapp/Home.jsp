<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html>
	<html lang="en">

	<head>
		<meta charset="UTF-8">
		<title>Clothify</title>
		<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700;900&display=swap"
			rel="stylesheet">
		<script src="https://kit.fontawesome.com/f5c5a3b647.js" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="style.css">
		<style type="text/css">
			* {
				margin: 0;
				padding: 0;
			}

			body {
				font-family: 'Poppins', sans-serif;
			}

			.wrapper {
				width: 1170px;
				margin: auto;
			}

			header {
				/* background: linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)), url(https://i.postimg.cc/YjcJg24M/aa.jpg); */
				background: linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)), url(https://images.pexels.com/photos/1132146/pexels-photo-1132146.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940);
				height: 100vh;
				-webkit-background-size: cover;
				background-size: cover;
				background-position: center center;
				position: relative;
			}

			.nav-area {
				float: right;
				list-style: none;
				margin-top: 30px;
			}

			.nav-area li {
				display: inline-block;
			}

			.nav-area li a {
				color: #fff;
				text-decoration: none;
				padding: 5px 20px;
				font-family: poppins;
				font-size: 16px;
				text-transform: uppercase;
			}

			.nav-area li a:hover {
				background: #fff;
				color: #333;
			}

			.logo {
				float: left;
			}

			.logo img {
				width: 100%;
				padding: 15px 0;
			}

			.welcome-text {
				position: absolute;
				width: 900px;
				height: 300px;
				margin: 20% 30%;
				text-align: center;
			}

			.welcome-text h1 {
				text-align: center;
				color: #fff;
				text-transform: uppercase;
				font-size: 60px;
				overflow: hidden;
				/* Ensures the content is not revealed until the animation */
				border-right: .15em solid orange;
				/* The typwriter cursor */
				white-space: nowrap;
				/* Keeps the content on a single line */
				margin: 0 auto;
				/* Gives that scrolling effect as the typing happens */
				letter-spacing: .15em;
				/* Adjust as needed */
				animation:
					typing 3.5s steps(30, end),
					blink-caret .5s step-end infinite;
			}

			/* The typing effect */
			@keyframes typing {
				from {
					width: 0
				}

				to {
					width: 100%
				}
			}

			/* The typewriter cursor effect */
			@keyframes blink-caret {

				from,
				to {
					border-color: transparent
				}

				50% {
					border-color: orange
				}
			}

			.welcome-text h1 span {
				color: #00f6fe;
			}

			.welcome-text a {
				border: 1px solid #fff;
				padding: 10px 25px;
				text-decoration: none;
				text-transform: uppercase;
				font-size: 14px;
				margin-top: 20px;
				display: inline-block;
				color: #fff;
			}

			.welcome-text a:hover {
				background: #fff;
				color: #333;
			}

			/*resposive*/

			@media (max-width:600px) {
				.wrapper {
					width: 100%;
				}

				.logo {
					float: none;
					width: 50%;
					text-align: center;
					margin: auto;
				}

				img {
					width: auto;
				}

				.nav-area {
					float: none;
					margin-top: 0;
				}

				.nav-area li a {
					padding: 5px;
					font-size: 11px;
				}

				.nav-area {
					text-align: center;
				}

				.welcome-text {
					width: 100%;
					height: auto;
					margin: 30% 0;
				}

				.welcome-text h1 {
					font-size: 40px;
					color: #fff;
					overflow: hidden;
					/* Ensures the content is not revealed until the animation */
					border-right: .15em solid orange;
					/* The typwriter cursor */
					white-space: nowrap;
					/* Keeps the content on a single line */
					margin: 0 auto;
					/* Gives that scrolling effect as the typing happens */
					letter-spacing: .15em;
					/* Adjust as needed */
					animation:
						typing 3.5s steps(30, end),
						blink-caret .5s step-end infinite;
				}

				/* The typing effect */
				@keyframes typing {
					from {
						width: 0
					}

					to {
						width: 100%
					}
				}

				/* The typewriter cursor effect */
				@keyframes blink-caret {

					from,
					to {
						border-color: transparent
					}

					50% {
						border-color: orange
					}
				}
			}
		</style>
	</head>

	<body>
		<header>
			<div class="wrapper">
				<div class="logo">
					<img src="https://i.pinimg.com/280x280_RS/9c/6a/00/9c6a00e3071b7977e9ad739c837a74ad.jpg" alt=""
						height="60px" width="60px">
					<!-- <img src="https://images.pexels.com/photos/35185/hats-fedora-hat-manufacture-stack.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
						alt="" height="60px" width="60px"> -->
				</div>
				<ul class="nav-area">
					<li><a href="/home">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="/admin">Admin Login</a></li>
					<li><a href="/user">User Login</a></li>
					<li><a href="/signup">User SignUp</a></li>
				</ul>
			</div>
			<div class="welcome-text">
				<h1 class="animation">Welcome to <span>Clothify</span></h1>
				<a href="#">One shop stop for your garments</a>
			</div>
		</header>

	</body>

	</html>
