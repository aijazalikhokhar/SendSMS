var SMS = {
    send: function(number,msg,successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'SendSMS', // mapped to our native Java class called "CalendarPlugin"
            'sendMessage', // with this action name
            [number,msg]
        ); 
    }
}
module.exports = SMS;