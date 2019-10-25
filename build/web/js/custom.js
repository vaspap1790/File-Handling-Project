
$('input[type=file]').change(function () {
    if ($('input[type=file]').val() == '') {
        $('#submit').attr('disabled', true)
    } else {
        $('#submit').attr('disabled', false);
    }
})

function validate() {

    var file_size = $('#file')[0].files[0].size;
    if (file_size > 104857600) {
        alert("File size cannot be greater than 100MB");
        return false;
    }
    return true;
}


$(document).ready(function () {
    $("#submit").click(function (e) {
        $("#myform").find("input[type=file]").each(function (index, field) {
            for (var i = 0; i < field.files.length; i++) {
                const file = field.files[i];
                if (file.size > 104857600 || file.fileSize > 104857600) {
                    errorMessage = 'Files must be less than 100MB.';
                    alert(errorMessage);
                }
            }
        });
    });
});


// function getExtension(filename) {
//     var parts = filename.split('.');
//     return parts[parts.length - 1];
// }

// function isImage(filename) {

//     return ((/\.(gif|jpg|jpeg|tiff|png)$/i).test(filename));
// }

function isVideo(filename) {
    return (/\.(gif|jpg|jpeg|tiff|png)$/i).test(filename);
}


function displayType() {
    document.querySelectorAll('.type').forEach(myfunction);

    function myfunction(item) {

        var name = item.nextElementSibling.textContent;
        console.log(name);
        var nametrimmed = name.trim();
        
        console.log(nametrimmed);
        console.log((/\.(gif|jpg|jpeg|tiff|png)$/i).test(nametrimmed));

        if ((/\.(gif|jpg|jpeg|tiff|png)$/i).test(nametrimmed)) {
            item.innerHTML = '<i class="fas fa-camera-retro"></i>';
        }
        else if ((/\.(mov|mpg|mpeg|wmv|avi|mp4)$/i).test(nametrimmed)) {
            item.innerHTML = '<i class="fas fa - film"></i>';
        }
        else {
            item.innerHTML = '<i class="far fa - file - alt"></i>';
        }
    }
}

$(document).ready(displayType);

