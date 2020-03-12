<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Event profile</title>

    <!-- Icons font CSS-->
    <link href="/profile/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="/profile/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="/profile/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="/profile/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/mainpro.css" rel="stylesheet" media="all">
</head>
<body>
    <div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
        <div class="wrapper wrapper--w960">
            <div class="card card-2">
                <div class="card-heading"></div>
                <div class="card-body">
                    <h2 class="title">Organizers Registration</h2>
                    <form method="POST">
                        <div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="Event Name">
                                    <option disabled="disabled" selected="selected">Select Event</option>
                                    <option>RPA Hackathon</option>
                                    <option>Lets code Coimbatore</option>
                                    <option>Science Conference</option>
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                        <div class="input-group">
                         <input class="input--style-2" type="text" placeholder="Organizer Name" name="name">
                        </div>
                        <div class="input-group">
                         <input class="input--style-2" type="text" placeholder="person of contact" name="name">
                        </div>
                        <div class="input-group">
                         <input class="input--style-2" type="text" placeholder="E-mail" name="name">
                        </div>
                        <div class="input-group">
                         <input class="input--style-2" type="text" placeholder="Phone number" name="name">
                        </div>
                        <div class="p-t-30">
                            <button class="btn btn--radius btn--green" type="submit">Search</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
<script src="/profile/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="/profile/select2/select2.min.js"></script>
    <script src="/profile/datepicker/moment.min.js"></script>
    <script src="/profile/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/globalpro.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->