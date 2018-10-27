<div class="container" style="margin-top: 15px;">
        <div class="row">
          <div class="col">
            <div class="card card-body bg-light mt-2 p-5">

                <div class="row">
                <div class="form-group">
                    <label class="control-label"><h3><span id="schoolName"></span> Dashboard</h3></label>
                    <div class="form-group">
                        <div class="input-group mt-2">
                            <input type="text" class="form-control" placeholder="Search students.." id="search">
                            <div class="input-group-append">
                                <span class="input-group-text"><i class="fa fa-search"></i></span>
                            </div>
                        </div>
                    </div>
                </div>

                <img src="_assets/img/school_logo.png" alt="logo" class="ml-auto" height="100px;">
                </div> 
<hr>
                <div class="row justify-content-center align-items-center">
                    <div class="col-md-8">
                        <form id="form">
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label class="col-form-label" for="fname">Firsn Name:</label>
                                    <input class="form-control" placeholder="First Name" id="fname" name="fname" type="text">
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="col-form-label" for="lname">Last Name:</label>
                                    <input class="form-control" placeholder="Last Name" id="lname" name="lname" type="text">
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label class="col-form-label" for="idnum">ID Number:</label>
                                    <input class="form-control" placeholder="ID Number" id="idnum" type="text">
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="col-form-label" for="lastName">Date of Birth:</label>
                                    <input class="form-control" placeholder="Date of Birth" id="lastName" type="date">
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label class="col-form-label" for="emailAddress">Gender:</label>
                                    <div class="form-group">
                                        <select class="custom-select" name="gender" id="gender">
                                            <option selected="">Select Gender</option>
                                            <option value="female">Female</option>
                                            <option value="male">Male</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="col-form-label" for="phoneNum">Contact Info:</label>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Contact Info" id="lastName" type="text">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label class="col-form-label" for="subjects">Class Stream:</label>
                                    <div class="form-group">
                                        <select class="custom-select" name="subjects" id="subjects">
                                            <option selected="">Class Stream..</option>
                                            <option value="science">Class of Science</option>
                                            <option value="geography">Class of Geography</option>
                                            <option value="art">Class of Art</option>
                                            <option value="accounting">Class of Accounting</option>
                                            <option value="cat">Class of Technology</option>                                        
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="col-form-label" for="grade">Grade Enrolled:</label>
                                    <input class="form-control" placeholder="Grade Enrolled" id="grade" type="number" min="8" max="12">
                                    <a href="#" class="btn btn-info float-right mt-3" role="button" id="btnNext">Next <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>

                            <div class="row">
                                
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Latest Toasteo JS -->
<script src="_vendor/toasteo/dist/js/app.js"></script>
  <script src="_vendor/js/functions.js"></script> 
     <script>
        $(document).ready(function () {
            debugger
            defaultFunction();
            var data = JSON.parse(window.localStorage.getItem('NAME'));
            var queries = data.split(' ');

            for(var i = 0; i < queries.length; i++){
                debugger
                if(i === 0){
                    $('#fname').val(queries[i]);
                    $('#fname').attr('readonly','');
                }else{
                    $('#lname').val($('#lname').val().trim() + " " + queries[i]);
                    $('#lname').attr('readonly', '');
                }

                $('#fname').each(function () {
                    var label = $("label[for='" + $(this).attr('id') + "']");
                    console.log(label);
                })
                
            }

            ajaxCall(null, 'GET', data);

            
        });
    </script>