print("---START: Database creation")
print("Get messages DB")

db = db.getSiblingDB("messages")


print("Create user admin for messages")
db.createUser({
    user: 'admin',
    pwd: 'admin',
    roles: [
        {
            role: 'readWrite',
            db: 'messages',
        },
    ],
});

print("create collection notification")
db.createCollection('notification', { capped: false })

print("create sample data into notifications")
db.notification.insert([
   {  
        "_id" : "95b03c43-6b54-40c3-a9a3-be0a2795eeef",
        "description" : "watering reminder", 
        "message" : "Weekly reminder to water your Orchid. ;)", 
        "creationDate": new Date(2020,01,12,8,45,43),
        "enabled" : true,
        "recipientsIds" : ["f8bd2af6-d341-4e1c-9cec-69e78afd31e9", "5d56add6-de94-4f30-9536-485f4e568de2"],
        "schedule" : {
            "startDate" : new Date(2021,01,12,8,00,01),
            "endDate" : null,
            "periodicity" : "Daily"
        } 
   },
   {  
        "_id" : "a4b945ca-e45f-408d-b671-1a4c899073b0",
        "description" : "sun light reminder", 
        "message" : "Weekly reminder to make sure your Orchid has enough sunlight exposure!", 
        "creationDate": new Date(),
        "enabled" : true,
        "recipientsIds" : ["f8bd2af6-d341-4e1c-9cec-69e78afd31e9", "5d56add6-de94-4f30-9536-485f4e568de2"],
        "schedule" : {
            "startDate" : new Date(),
            "endDate" : null,
            "periodicity" : "Daily"
        } 
   },
   {  
        "_id" : "1672dc46-271d-4e96-9f99-a361887ef924",
        "description" : "temperature reminder", 
        "message" : "Weekly reminder to make sure the room temperature is between 20C and 25C)", 
        "creationDate": new Date(2020,01,12,8,45,43),
        "enabled" : true,
        "recipientsIds" : ["f8bd2af6-d341-4e1c-9cec-69e78afd31e9", "5d56add6-de94-4f30-9536-485f4e568de2"],
        "schedule" : {
            "startDate" : new Date(2021,01,12,8,00,01),
            "endDate" : null,
            "periodicity" : "Daily"
        } 
   }
]);

print("create collection recipient")
db.createCollection('recipient', {capped : false})
db.recipient.insert([
    {
        "_id" : "5d56add6-de94-4f30-9536-485f4e568de2",
        "firstName" : "Lucas",
        "lastName" : "Vieira",
        "email" : "lucasterravieira@gmail.com",
        "phone" : "+16047246861",
        "enablePhoneNotification" : false,
        "enableEmailNotification" : true
    },
    {
        "_id" : "f8bd2af6-d341-4e1c-9cec-69e78afd31e9",
        "firstName" : "Wolfgang",
        "lastName" : "Mozart",
        "email" : "wmozart@gmail.com",
        "phone" : "+16047246861",
        "enablePhoneNotification" : false,
        "enableEmailNotification" : true
    },
]);

print("create notification list")
db.createCollection('notificationList', {capped : false })
db.notificationList.insert([
    {
        "_id" : "7693f785-dfc3-446d-a1f2-7620d125b2de",
        "description" : "notification list 1",
        "recipientsIds" : ["5d56add6-de94-4f30-9536-485f4e568de2", "f8bd2af6-d341-4e1c-9cec-69e78afd31e9"],
        "notificationsIds" : ["f8bd2af6-d341-4e1c-9cec-69e78afd31e9","a4b945ca-e45f-408d-b671-1a4c899073b0"]
    },
    {
        "_id" : "1ed4ff19-40d9-43ff-974b-1b67ac1b83a8",
        "description" : "notification list 2",
        "recipientsIds" : ["5d56add6-de94-4f30-9536-485f4e568de2", "f8bd2af6-d341-4e1c-9cec-69e78afd31e9"],
        "notificationsIds" : ["1672dc46-271d-4e96-9f99-a361887ef924"]
    }
]);
print("---END: Database creation")