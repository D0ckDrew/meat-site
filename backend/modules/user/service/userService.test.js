const userService = require("../service/userService");
const LoginStatus = require("../model/loginStatus");

test('test incorrect login data', async () => {
    expect((await userService.login("incorrect","incorrect")).status).toBe(LoginStatus.INVALID_DATA);
});

test('test correct login data', async () => {
    expect((await userService.login("andrey_krasnomyasov","FqR9191Jz")).status).toBe(LoginStatus.OK);
});

test('test incorrect password', async () => {
    expect((await userService.login("andrey_krasnomyasov","incorrect")).status).toBe(LoginStatus.INVALID_DATA);
});