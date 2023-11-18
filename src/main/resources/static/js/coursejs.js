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
