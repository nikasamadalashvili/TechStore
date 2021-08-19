<%--
  Created by IntelliJ IDEA.
  User: nika
  Date: 16.08.21
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--Section: Block Content-->
<jsp:useBean id="mobileDetails" scope="request" type="web.app.TechStore.TechStore.Services.models.MobileDetailsResponse"/>
<section class="mb-5">

    <div class="row">
        <div class="col-md-6 mb-4 mb-md-0">

            <div id="mdb-lightbox-ui"></div>

            <div class="mdb-lightbox">

                <div class="row product-gallery mx-1">

                    <div class="col-12 mb-0">
                        <figure class="view overlay rounded z-depth-1 main-img">
                            <a href="images/${mobileDetails.imageName}"
                               data-size="710x823">
                                <img src="images/${mobileDetails.imageName}"
                                     class="img-fluid z-depth-1">
                            </a>
                        </figure>
                        <figure class="view overlay rounded z-depth-1" style="visibility: hidden;">
                            <a href="images/${mobileDetails.imageName}"
                               data-size="710x823">
                                <img src="images/${mobileDetails.imageName}"
                                     class="img-fluid z-depth-1">
                            </a>
                        </figure>
                        <figure class="view overlay rounded z-depth-1" style="visibility: hidden;">
                            <a href="images/${mobileDetails.imageName}"
                               data-size="710x823">
                                <img src="images/${mobileDetails.imageName}"
                                     class="img-fluid z-depth-1">
                            </a>
                        </figure>
                        <figure class="view overlay rounded z-depth-1" style="visibility: hidden;">
                            <a href="images/${mobileDetails.imageName}"
                               data-size="710x823">
                                <img src="images/${mobileDetails.imageName}"
                                     class="img-fluid z-depth-1">
                            </a>
                        </figure>
                    </div>
                    <div class="col-12">
                        <div class="row">
                            <div class="col-3">
                                <div class="view overlay rounded z-depth-1 gallery-item">
                                    <img src="images/${mobileDetails.imageName}"
                                         class="img-fluid">
                                    <div class="mask rgba-white-slight"></div>
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="view overlay rounded z-depth-1 gallery-item">
                                    <img src="images/${mobileDetails.imageName}"
                                         class="img-fluid">
                                    <div class="mask rgba-white-slight"></div>
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="view overlay rounded z-depth-1 gallery-item">
                                    <img src="images/${mobileDetails.imageName}"
                                         class="img-fluid">
                                    <div class="mask rgba-white-slight"></div>
                                </div>
                            </div>
                            <div class="col-3">
                                <div class="view overlay rounded z-depth-1 gallery-item">
                                    <img src="images/${mobileDetails.imageName}"
                                         class="img-fluid">
                                    <div class="mask rgba-white-slight"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
        <div class="col-md-6">

            <h5>${mobileDetails.name}</h5>
            <p class="mb-2 text-muted text-uppercase small">Mobiles</p>
            <ul class="rating">
                <li>
                    <i class="fas fa-star fa-sm text-primary"></i>
                </li>
                <li>
                    <i class="fas fa-star fa-sm text-primary"></i>
                </li>
                <li>
                    <i class="fas fa-star fa-sm text-primary"></i>
                </li>
                <li>
                    <i class="fas fa-star fa-sm text-primary"></i>
                </li>
                <li>
                    <i class="far fa-star fa-sm text-primary"></i>
                </li>
            </ul>
            <p><span class="mr-1"><strong>$${mobileDetails.price}</strong></span></p>
            <p class="pt-1">Lorem ipsum dolor sit amet consectetur adipisicing elit. Numquam, sapiente illo. Sit
                error voluptas repellat rerum quidem, soluta enim perferendis voluptates laboriosam. Distinctio,
                officia quis dolore quos sapiente tempore alias.</p>
            <div class="table-responsive">
                <table class="table table-sm table-borderless mb-0">
                    <tbody>
                    <tr>
                        <th class="pl-0 w-25" scope="row"><strong>Name</strong></th>
                        <td>${mobileDetails.name}</td>
                    </tr>
                    <tr>
                        <th class="pl-0 w-25" scope="row"><strong>Acceleremeter</strong></th>
                        <td>${mobileDetails.acceleremeter}</td>
                    </tr>
                    <tr>
                        <th class="pl-0 w-25" scope="row"><strong>adapter</strong></th>
                        <td>${mobileDetails.adapter}</td>
                    </tr>
                    <tr>
                        <th class="pl-0 w-25" scope="row"><strong>aGps</strong></th>
                        <td>${mobileDetails.aGps}</td>
                    </tr>
                    <tr>
                        <th class="pl-0 w-25" scope="row"><strong>aperture</strong></th>
                        <td>${mobileDetails.aperture}</td>
                    </tr>
                    <tr>
                        <th class="pl-0 w-25" scope="row"><strong>availableQuantity</strong></th>
                        <td>${mobileDetails.availableQuantity}</td>
                    </tr>
                    <tr>
                        <th class="pl-0 w-25" scope="row"><strong>batteryDescription</strong></th>
                        <td>${mobileDetails.batteryDescription}</td>
                    </tr>                    <tr>
                        <th class="pl-0 w-25" scope="row"><strong>bluetooth</strong></th>
                        <td>${mobileDetails.bluetooth}</td>
                    </tr>
                    <tr>
                        <th class="pl-0 w-25" scope="row"><strong>brightness</strong></th>
                        <td>${mobileDetails.brightness}</td>
                    </tr>
                    <tr>
                        <th class="pl-0 w-25" scope="row"><strong>dolbyVision</strong></th>
                        <td>${mobileDetails.dolbyVision}</td>
                    </tr>
                    <tr>
                        <th class="pl-0 w-25" scope="row"><strong>fingerprint</strong></th>
                        <td>${mobileDetails.fingerprint}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <hr>
            <div class="table-responsive mb-2">
                <table class="table table-sm table-borderless">
                    <tbody>
                    <tr>
                        <td class="pl-0 pb-0 w-25">Quantity</td>
                        <td class="pb-0">Select size</td>
                    </tr>
                    <tr>
                        <td class="pl-0">
                            <div class="def-number-input number-input safari_only mb-0">
                                <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                                        class="minus"></button>
                                <input id="quantity" class="quantity" min="0" name="quantity" value="1" type="number">
                                <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                                        class="plus"></button>
                            </div>
                        </td>
                        <td>
                            <div class="mt-1">
                                <div class="form-check form-check-inline pl-0">
                                    <input type="radio" class="form-check-input" id="small" name="materialExampleRadios"
                                           checked>
                                    <label class="form-check-label small text-uppercase card-link-secondary"
                                           for="small">Small</label>
                                </div>
                                <div class="form-check form-check-inline pl-0">
                                    <input type="radio" class="form-check-input" id="medium" name="materialExampleRadios">
                                    <label class="form-check-label small text-uppercase card-link-secondary"
                                           for="medium">Medium</label>
                                </div>
                                <div class="form-check form-check-inline pl-0">
                                    <input type="radio" class="form-check-input" id="large" name="materialExampleRadios">
                                    <label class="form-check-label small text-uppercase card-link-secondary"
                                           for="large">Large</label>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <form id="shopping-cart" method="post" action="shopping-cart?userId=4&productId=${mobileDetails.productId}&productQuantity="+>
                <button type="button" class="btn btn-primary btn-md mr-1 mb-2">Buy now</button>
                <button onclick="submitShoppingCart()" class="btn btn-light btn-md mr-1 mb-2"><i
                        class="fas fa-shopping-cart pr-2"></i>Add to cart</button>
            </form>
        </div>
    </div>

</section>
<!--Section: Block Content-->
<script>
    function submitShoppingCart() {
        let form = document.getElementById('shopping-cart');
        form.action += document.getElementById('quantity').value;
        form.submit();
    }
</script>