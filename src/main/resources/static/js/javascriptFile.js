/*<![CDATA[*/
    var students = /*[[${students}]]*/ [];
    function loadStudentData() {
        var id = document.getElementById("studentIds").value;
        var selectedStudent = students.find(s => s.id == id);
        if(selectedStudent) {
            document.getElementById("firstName").value = selectedStudent.firstName;
            document.getElementById("lastName").value = selectedStudent.lastName;
            document.getElementById("organisation").value = selectedStudent.organisation;
            document.getElementById("mailingAddress").value = selectedStudent.mailingAddress;
            document.getElementById("city").value = selectedStudent.city;
            document.getElementById("province").value = selectedStudent.province;
            document.getElementById("postalCode").value = selectedStudent.postalCode;
            document.getElementById("country").value = selectedStudent.country;
            document.getElementById("telephone").value = selectedStudent.telephone;
            document.getElementById("fax").value = selectedStudent.fax;
            document.getElementById("email").value = selectedStudent.email;
            document.getElementById("gender").value = selectedStudent.gender;
            document.getElementById("dateBirth").value = selectedStudent.dateBirth;
        }
        console.log(selectedStudent);
        console.log(id);
        console.log(students);
    }
/*]]>*/

document.getElementById('deleteButton').addEventListener('click', function() {
    var id = document.getElementById("studentIds").value;
    fetch('/delete/' + id, { method: 'POST' })
        .then(response => {
            if (response.ok) {
                window.location.href = "/student";
            } else {
                // Gérez les erreurs, montrez un message à l'utilisateur, etc.
                console.error('Erreur lors de la suppression');
            }
        });
});


function updateCourseDetails() {
    var selectElement = document.getElementById('courseIds');
    var selectedId = selectElement.value;

    fetch('/course/api/' + selectedId)
        .then(response => response.json())
        .then(course => {
            document.getElementById('courseName').value = course.courseName;
            document.getElementById('courseCode').value = course.courseCode;
            document.getElementById('description').value = course.description;
        })
        .catch(error => console.error('Error fetching course data:', error));
}
