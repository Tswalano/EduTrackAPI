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
              <table class="table table-hover mt-3" id="table">
                <thead>
                  <tr style="background-color:#b3dcd9;color:#02001D;">
                    <th scope="col">School Name</th>
                    <th scope="col">Student Name</th>
                    <th scope="col">Date of Birth</th>
                    <th scope="col">Gender</th>
                    <th scope="col">District</th>
                    <th scope="col">Province</th>                    
                  </tr>
                </thead>
                <tbody id="tableResults">
                  <tr></tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
    </div>
<!-- Latest Toasteo JS -->
  <script src="_vendor/toasteo/dist/js/app.js"></script>
  <script src="_vendor/js/functions.js"></script> 
  
     <script>
        $(document).ready(function () {
          defaultFunction();

          $(document).on('click', '#table tbody tr', function (e) {
            var x = $(this).addClass('selected').siblings().removeClass('selected');
            var val = $(this).find('td:nth-child(2)').html();
debugger
            if(window.localStorage.getItem('NAME') !== undefined){
              window.localStorage.removeItem('NAME');
            }
            window.localStorage.setItem('NAME', JSON.stringify(val));

            document.location = '#/add-student?school=' + val;
            window.Toasteo.warning(val);
          });

          $('#search').on('keyup', function () {
                var value = $(this).val().toLowerCase();
                $('#tableResults tr').filter(function() {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });

          jQuery.ajax({
            url: "http://localhost:8080/api/v1/students/",
            type: "GET",
            dataType: "json",
            crossDomain: true,
            
            success: function (data) {
              console.log(data[1].school[0].users);       

              $.each(data, function (i,student) {
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