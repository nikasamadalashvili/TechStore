<%--
  Created by IntelliJ IDEA.
  User: nika
  Date: 16.08.21
  Time: 04:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-4 mb-4">

  <!-- Section: Sidebar -->
  <section>

    <!-- Section: Categories -->
    <section>

      <h5>Subcategories</h5>

      <div class="text-muted small text-uppercase mb-5">
        <p class="mb-4">return to <a href="#!" class="card-link-secondary"><strong>Clothing, Shoes,
          Accessories</strong></a></p>

        <p class="mb-3"><a href="#!" class="card-link-secondary">Dresses</a></p>
        <p class="mb-3"><a href="#!" class="card-link-secondary">Tops, Tees & Blouses</a></p>
        <p class="mb-3"><a href="#!" class="card-link-secondary">Sweaters</a></p>
        <p class="mb-3"><a href="#!" class="card-link-secondary">Fashion Hoodies & Sweatshirts</a></p>
        <p class="mb-3"><a href="#!" class="card-link-secondary">Jeans</a></p>
      </div>

    </section>
    <!-- Section: Categories -->

    <!-- Section: Filters -->
    <section class="filters">
      <h5>Filters</h5>

      <!-- Section: Condition -->
      <section class="mb-4">
        <h6 class="font-weight-bold mb-3">Condition</h6>

        <div class="form-check pl-0 mb-3">
          <input
                  type="checkbox"
                  class="form-check-input filled-in"
                  id="new"
          />
          <label
                  class="form-check-label small text-uppercase card-link-secondary"
                  for="new"
          >New</label
          >
        </div>
        <div class="form-check pl-0 mb-3">
          <input
                  type="checkbox"
                  class="form-check-input filled-in"
                  id="used"
          />
          <label
                  class="form-check-label small text-uppercase card-link-secondary"
                  for="used"
          >Used</label
          >
        </div>
        <div class="form-check pl-0 mb-3">
          <input
                  type="checkbox"
                  class="form-check-input filled-in"
                  id="collectible"
          />
          <label
                  class="form-check-label small text-uppercase card-link-secondary"
                  for="collectible"
          >Collectible</label
          >
        </div>
        <div class="form-check pl-0 mb-3 pb-1">
          <input
                  type="checkbox"
                  class="form-check-input filled-in"
                  id="renewed"
          />
          <label
                  class="form-check-label small text-uppercase card-link-secondary"
                  for="renewed"
          >Renewed</label
          >
        </div>
      </section>
      <!-- Section: Condition -->

      <!-- Section: Average -->
      <section>
        <h6 class="font-weight-bold mb-3">Avg. Customer Review</h6>

        <label for="customer-rating-4" class="z-depth-0 py-0">
          <ul class="rating waves-light mb-0">
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
            <li>
              <p class="small text-uppercase card-link-secondary px-2">
                & Up
              </p>
            </li>
          </ul>
          <input
                  id="customer-rating-4"
                  class="filter-option"
                  type="checkbox"
          />
        </label>
        <br />
        <label for="customer-rating-3" class="z-depth-0 py-0">
          <ul class="rating waves-light mb-0">
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
            <li>
              <i class="far fa-star fa-sm text-primary"></i>
            </li>
            <li>
              <p class="small text-uppercase card-link-secondary px-2">
                & Up
              </p>
            </li>
          </ul>
          <input
                  id="customer-rating-3"
                  class="filter-option"
                  type="checkbox"
          />
        </label>
        <br />
        <label for="customer-rating-2" class="z-depth-0 py-0">
          <ul class="rating waves-light mb-0">
            <li>
              <i class="fas fa-star fa-sm text-primary"></i>
            </li>
            <li>
              <i class="fas fa-star fa-sm text-primary"></i>
            </li>
            <li>
              <i class="far fa-star fa-sm text-primary"></i>
            </li>
            <li>
              <i class="far fa-star fa-sm text-primary"></i>
            </li>
            <li>
              <i class="far fa-star fa-sm text-primary"></i>
            </li>
            <li>
              <p class="small text-uppercase card-link-secondary px-2">
                & Up
              </p>
            </li>
          </ul>
          <input
                  id="customer-rating-2"
                  class="filter-option"
                  type="checkbox"
          />
        </label>
        <br />
        <label for="customer-rating-1" class="z-depth-0 py-0">
          <ul class="rating waves-light mb-0">
            <li>
              <i class="fas fa-star fa-sm text-primary"></i>
            </li>
            <li>
              <i class="far fa-star fa-sm text-primary"></i>
            </li>
            <li>
              <i class="far fa-star fa-sm text-primary"></i>
            </li>
            <li>
              <i class="far fa-star fa-sm text-primary"></i>
            </li>
            <li>
              <i class="far fa-star fa-sm text-primary"></i>
            </li>
            <li>
              <p class="small text-uppercase card-link-secondary px-2">
                & Up
              </p>
            </li>
          </ul>
          <input
                  id="customer-rating-1"
                  class="filter-option"
                  type="checkbox"
          />
        </label>
      </section>
      <!-- Section: Average -->

      <!-- Section: Price -->
      <section class="mb-4">
        <h6 class="font-weight-bold mb-3">Price</h6>

        <div class="form-check pl-0 mb-3">
          <input
                  type="radio"
                  class="form-check-input"
                  id="under25"
                  name="materialExampleRadios"
          />
          <label
                  class="form-check-label small text-uppercase card-link-secondary"
                  for="under25"
          >Under $25</label
          >
        </div>
        <div class="form-check pl-0 mb-3">
          <input
                  type="radio"
                  class="form-check-input"
                  id="2550"
                  name="materialExampleRadios"
          />
          <label
                  class="form-check-label small text-uppercase card-link-secondary"
                  for="2550"
          >$25 to $50</label
          >
        </div>
        <div class="form-check pl-0 mb-3">
          <input
                  type="radio"
                  class="form-check-input"
                  id="50100"
                  name="materialExampleRadios"
          />
          <label
                  class="form-check-label small text-uppercase card-link-secondary"
                  for="50100"
          >$50 to $100</label
          >
        </div>
        <div class="form-check pl-0 mb-3">
          <input
                  type="radio"
                  class="form-check-input"
                  id="100200"
                  name="materialExampleRadios"
          />
          <label
                  class="form-check-label small text-uppercase card-link-secondary"
                  for="100200"
          >$100 to $200</label
          >
        </div>
        <div class="form-check pl-0 mb-3">
          <input
                  class="form-check-input"
                  id="200above"
                  name="materialExampleRadios"
          />
          <label
                  class="form-check-label small text-uppercase card-link-secondary"
                  for="200above"
          >$200 & Above</label
          >
        </div>
      </section>
      <!-- Section: Price -->

      <!-- Section: Size -->
      <section class="mb-4">
        <h6 class="font-weight-bold mb-3">Size</h6>

        <div class="form-check pl-0 mb-3">
          <input
                  type="checkbox"
                  class="form-check-input filled-in"
                  id="34"
          />
          <label
                  class="form-check-label small text-uppercase card-link-secondary"
                  for="34"
          >34</label
          >
        </div>
        <div class="form-check pl-0 mb-3">
          <input
                  type="checkbox"
                  class="form-check-input filled-in"
                  id="36"
          />
          <label
                  class="form-check-label small text-uppercase card-link-secondary"
                  for="36"
          >36</label
          >
        </div>
        <div class="form-check pl-0 mb-3">
          <input
                  type="checkbox"
                  class="form-check-input filled-in"
                  id="38"
          />
          <label
                  class="form-check-label small text-uppercase card-link-secondary"
                  for="38"
          >38</label
          >
        </div>
        <div class="form-check pl-0 mb-3">
          <input
                  type="checkbox"
                  class="form-check-input filled-in"
                  id="40"
          />
          <label
                  class="form-check-label small text-uppercase card-link-secondary"
                  for="40"
          >40</label
          >
        </div>
        <a
                class="btn btn-link text-muted p-0"
                data-toggle="collapse"
                href="#collapseExample"
                aria-expanded="false"
                aria-controls="collapseExample"
        >
          More
        </a>
        <div class="collapse pt-3" id="collapseExample">
          <div class="form-check pl-0 mb-3">
            <input
                    type="checkbox"
                    class="form-check-input filled-in"
                    id="42"
            />
            <label
                    class="form-check-label small text-uppercase card-link-secondary"
                    for="42"
            >42</label
            >
          </div>
          <div class="form-check pl-0 mb-3">
            <input
                    type="checkbox"
                    class="form-check-input filled-in"
                    id="44"
            />
            <label
                    class="form-check-label small text-uppercase card-link-secondary"
                    for="44"
            >44</label
            >
          </div>
          <div class="form-check pl-0 mb-3">
            <input
                    type="checkbox"
                    class="form-check-input filled-in"
                    id="46"
            />
            <label
                    class="form-check-label small text-uppercase card-link-secondary"
                    for="46"
            >46</label
            >
          </div>
          <div class="form-check pl-0 mb-3">
            <input
                    type="checkbox"
                    class="form-check-input filled-in"
                    id="50"
            />
            <label
                    class="form-check-label small text-uppercase card-link-secondary"
                    for="50"
            >50</label
            >
          </div>
        </div>
      </section>
      <!-- Section: Size -->

      <!-- Section: Color -->
      <section class="mb-4">
        <h6 class="font-weight-bold mb-3">Color</h6>

        <div
                class="btn-group btn-group-toggle btn-color-group d-block mt-n2 ml-n2"
                data-toggle="buttons"
        >
          <label
                  for="color-1"
                  class="btn rounded-circle white border-inset-grey p-3 m-2"
          >
            <input
                    id="color-1"
                    class="filter-option"
                    type="checkbox"
            />
          </label>
          <label for="color-2" class="btn rounded-circle grey p-3 m-2">
            <input
                    id="color-2"
                    class="filter-option"
                    type="checkbox"
            />
          </label>
          <label for="color-3" class="btn rounded-circle black p-3 m-2">
            <input
                    id="color-3"
                    class="filter-option"
                    type="checkbox"
            />
          </label>
          <label for="color-4" class="btn rounded-circle green p-3 m-2">
            <input
                    id="color-4"
                    class="filter-option"
                    type="checkbox"
            />
          </label>
          <label for="color-5" class="btn rounded-circle blue p-3 m-2">
            <input
                    id="color-5"
                    class="filter-option"
                    type="checkbox"
            />
          </label>
          <label for="color-6" class="btn rounded-circle purple p-3 m-2">
            <input
                    id="color-6"
                    class="filter-option"
                    type="checkbox"
            />
          </label>
          <label for="color-7" class="btn rounded-circle yellow p-3 m-2">
            <input
                    id="color-7"
                    class="filter-option"
                    type="checkbox"
            />
          </label>
          <label for="color-8" class="btn rounded-circle indigo p-3 m-2">
            <input
                    id="color-8"
                    class="filter-option"
                    type="checkbox"
            />
          </label>
          <label for="color-9" class="btn rounded-circle red p-3 m-2">
            <input
                    id="color-9"
                    class="filter-option"
                    type="checkbox"
            />
          </label>
          <label for="color-10" class="btn rounded-circle orange p-3 m-2">
            <input
                    id="color-10"
                    class="filter-option"
                    type="checkbox"
            />
          </label>
        </div>
      </section>
      <!-- Section: Color -->
    </section>
    <!-- Section: Filters -->

  </section>
  <!-- Section: Sidebar -->

</div>
<div class="col-md-8 mb-4">
  <div class="container">
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
      <jsp:useBean id="mobiles" scope="request" type="java.util.List"/>
      <c:forEach var="mobile" items="${mobiles}">
        <div class="col">
          <div class="card shadow-sm">
            <img src="images/${mobile.getImageName()}" class="img-fluid">
            <div class="card-body">
              <p class="card-text">Name: ${mobile.getName()}, Price: ${mobile.getPrice()}</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                </div>
                <small class="text-muted">9 mins</small>
              </div>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</div>
</body>
<!-- MDB -->
<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.6.0/mdb.min.js"
></script>
</html>
