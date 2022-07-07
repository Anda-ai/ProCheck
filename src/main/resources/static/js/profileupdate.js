alert("yeep");
$("#profileupdate-form").on('submit', function(e){
    e.preventDefault();
    alert("clicked");
    var form = $(this)[0];
    let formData = new FormData(form); 

    $.ajax({
        url:"upload_profile",
        type: "POST", 
        data: formData,
        enctype: 'multipart/form-data',
        contentType: false,
        cache: false,
        processData:false,
        success: function (status) {
            alert("success"+status);
            window.location.href = "/";
        },
        error: function (response, errorThrown) {
            
            /*document.open();
            document.write(response.responseText);
            document.close();*/
            alert("error"+errorThrown);
            alert("error"+response.status);
            window.location = response.responseText;
            
        }
    });
});
$("#profilephoto_ajaxfile").on('change', function(e){
    const [file] = this.files;
    if (file) {
        document.getElementById("photo").src = URL.createObjectURL(file)
    }
});