  <div class="container">
    <div class="row">
      <div class="col-md-8 mx-auto">
        <div class="card card-body bg-light mt-5">
          <h2>Create Account</h2>
          <p>Fill in this form to register</p>
          <form id="registerForm">
            <div class="form-row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="fname">First Name</label>
                  <input type="text" name="fname" id="fname" class="form-control"
                    value="">
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="lname">Last Name</label>
                  <input type="text" name="lname" id="lname" class="form-control">
                </div>
              </div>
            </div>

            <div class="form-row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="email">Email Address</label>
                  <input type="text" name="email" id="email" class="form-control">              
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="school">School Name</label>
                  <select class="custom-select" name="school" id="school">
                    <option selected="">Select a school</option>
                    <option value="1">Uptown High School</option>
                    <option value="2">Highland Secondary School</option>
                    <option value="3">South Side High School</option>
                  </select>
                </div>
              </div>
            </div>
            
            <div class="form-row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="password">Password</label>
                  <input type="password" name="password" id="password" class="form-control">
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="confirm_password">Confirm Password</label>
                  <input type="password" name="confirm_password" id="confirm_password" class="form-control">
                </div>
              </div>
            </div>

            <div class="form-row">
              <div class="col">
                <input type="button" id="register" value="Register" class="btn btn-success btn-block">
              </div>
              <div class="col">
                <a href="login.php" class="btn btn-light btn-block">Have an account? Login</a>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
    <!-- Latest Toasteo JS -->
  <script src="_vendor/toasteo/dist/js/app.js"></script>
  <script src="_vendor/js/functions.js"></script> 
  <script>
    $(document).ready(function () {
      // defaultFunction();
      $("#register").click(function (event) {
        event.preventDefault();
        var data = $("#registerForm").serialize();
        register(data);
          
      })
    });
  </script>