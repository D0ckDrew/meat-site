
module.exports ={
    CLIENT_DOMAIN:"http://localhost:3000",
    PORT: process.env.PORT || 3001,
    SECRET: "tucrboPassword123",
    PRODUCTION: process.env.NODE_ENV === "production"
};