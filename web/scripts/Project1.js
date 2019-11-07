var Project1 = ( function () {
    
    return {
        addUser: function (fname, lname, dname, sessionid) {
            var that = this;
            var fname = $("#fname").val();
            var lname = $("#lname").val();
            var dname = $("#dname").val();
            var id = $("select").val();
            $.ajax({
                url: 'registration?code=' + fname + ";" + lname + ";" + dname + ";" + id,
                method: 'POST',
                dataType: 'json',
                success: function(response) {
                    that.outputJSON(response);
                }
            });
        },
        getSelection: function () {
            var that = this;
            var id = $("input").val();
            alert("Hello there!  This is a test!");
            $.ajax({
                url: 'registration?code=' + id,
                method: 'GET',
                dataType: 'html',
                success: function(response) {
                    that.output(response);                    
                }
            });    
        },
        
        output: function(response) {
            $("#output").html(response);
            
        },
        outputJSON: function(response) {
            var Gj = "You have registered as: ";
            var userNewcode = "Your registration code is: ";
            $("#output").html("<p>" + Gj + response["displayname"] + "<br>" + userNewcode + response["code"]);
        }
    };
}());