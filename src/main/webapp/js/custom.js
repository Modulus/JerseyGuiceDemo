/**
 * Created by Modulus on 23.05.2014.
 */
$(document).ready(function(){
    $("#sendit").click(function (event) {
        event.preventDefault();
        $.post("api/messages", function(data){
            alert(data);
        });
    });

    $.ajax({
        url: "api/users/all",
        success: function(data){
            console.log(data)
        },
        error: function (error) {
            console.log(error);
        }
    })
});