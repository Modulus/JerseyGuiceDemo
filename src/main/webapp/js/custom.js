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

    this.users = new UserViewModel();
    this.users.fetch()

});

function UserViewModel(){
    self = this;
    self.data = ko.observableArray([])
    self.fetch = function(){
        $.ajax({
            url: "api/users/all",
            success: function(data){
                data.user.forEach(function(row){
                   self.data.push(row)
                });
            },
            error: function (error) {
                console.log(error);
            }
        })
    }

}