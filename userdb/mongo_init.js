print("---START: Database creation")
print("Get messages DB")

db = db.getSiblingDB("users")


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

print("create collection user")
db.createCollection('user', {capped : false})
db.user.insert([
    {
        "_id" : "ec85841a-72ee-49fd-a7d3-49af046b3768",
        "firstName" : "Lucas",
        "lastName" : "Vieira",
        "email" : "lucasterravieira@gmail.com",
        "password" : "passw0rd",
        "role" : "admin",
        "expired" : false,
        "locked" : false,
        "credentialExpired" : false,
        "enabled" : true
    },
    {
        "_id" : "d3f316e2-8412-496e-a591-43e279db87ce",
        "firstName" : "Pyotr",
        "lastName" : "Tchaikovsky",
        "email" : "ptchaikovsky@gmail.com",
        "password" : "piano",
        "role" : "superuser",
        "expired" : false,
        "locked" : false,
        "credentialExpired" : false,
        "enabled" : true        
    }
]);

print("create collection role")
db.createCollection('role', {capped : false})
db.role.insert([
    {
        "role" : "admin",
        "permission" : null
    },
    {
        "role" : "superuser",
        "permission" : "+Password"
    }
]);


print("---END: Database creation")