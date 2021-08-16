<%--
  Created by IntelliJ IDEA.
  User: sopho
  Date: 8/16/2021
  Time: 2:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/3.6.95/css/materialdesignicons.css" rel="stylesheet">
<form action="creditCard-add" method="post">
    <div class="padding">
        <div class="row">
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-header">
                        <strong>Credit Card</strong>
                        <small>enter your card details</small>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label for="name">Name</label>
                                    <input class="form-control" id="name" type="text" placeholder="Enter your name" name="name">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <label for="ccnumber">Credit Card Number</label>
                                    <div class="input-group">
                                        <input class="form-control" type="text" placeholder="0000 0000 0000 0000" id="ccnumber" autocomplete="email" name="ccnumber">
                                        <div class="input-group-append">
                                        <span class="input-group-text">
                                            <i class="mdi mdi-credit-card"></i>
                                        </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4">
                                <label for="expdata">Expiration Date</label>
                                <input class="form-control" type=text name="expdate" id="expdata" placeholder="01.12.2022">
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="cvv">CVV/CVC</label>
                                    <input class="form-control" id="cvv" type="text" placeholder="123" name="cvv">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-sm btn-success float-right" type="submit">
                            <i class="mdi mdi-gamepad-circle"></i> Continue</button>
                        <button class="btn btn-sm btn-danger" type="reset">
                            <i class="mdi mdi-lock-reset"></i> Reset</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

<style type="text/css">
    .padding {
        padding: 5rem !important;
        margin-left: 300px
    }

    .card {
        margin-bottom: 1.5rem
    }

    .card {
        position: relative;
        display: -ms-flexbox;
        display: flex;
        -ms-flex-direction: column;
        flex-direction: column;
        min-width: 0;
        word-wrap: break-word;
        background-color: #fff;
        background-clip: border-box;
        border: 1px solid #c8ced3;
        border-radius: .25rem
    }

    .card-header:first-child {
        border-radius: calc(0.25rem - 1px) calc(0.25rem - 1px) 0 0
    }

    .card-header {
        padding: .75rem 1.25rem;
        margin-bottom: 0;
        background-color: #f0f3f5;
        border-bottom: 1px solid #c8ced3
    }

    .card-body {
        flex: 1 1 auto;
        padding: 1.25rem
    }

    .form-control:focus {
        color: #5c6873;
        background-color: #fff;
        border-color: #c8ced3 !important;
        outline: 0;
        box-shadow: 0 0 0 #F44336
    }
</style>
