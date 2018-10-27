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
            </div>
        </div>
    </div>
</div>
<!-- Latest Toasteo JS -->
<script src="_vendor/toasteo/dist/js/app.js"></script>
  <script src="_vendor/js/functions.js"></script> 
     <script>
        $(document).ready(function () {
            jQuery.ajax({
                url: "http://localhost:8080/api/v1/students/",
                type: "GET",
                dataType: "json",
                crossDomain: true,

                success: function (data) {
                    console.log(data[1].school[0].users);

                    var user = 'User ' + data[1].school[0].users[0].firstName;

                    $("#schoolName").text(data[0].school[0].schoolName);
                    $("#userLogged").text(user.toUpperCase());

                    $.each(data, function (i, student) {
                        $("#table > tbody").append(
                            $('<tr>').append(
                                $('<td>').append(student.school[0].schoolName),
                                $('<td>').append(student.firstName + ' ' + student.lastName),
                                $('<td>').append(student.dateOfBirth),
                                $('<td>').append(student.gender),
                                $('<td>').append(student.school[0].circuit),
                                $('<td>').append(student.school[0].province)
                            )
                        )
                        console.log(student.school[0].schoolName);
                    })
                },
                error: function (e) {
                    console.log('error');
                }
            });
        });
    </script>