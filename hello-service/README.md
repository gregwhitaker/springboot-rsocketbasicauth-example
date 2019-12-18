# hello-service
Service that returns a hello message.

## API
The `hello-service` exposes the following endpoints:

### hello
Endpoint that returns a hello message without authentication.

- Method: `hello`

### hello.secure
Endpoint that returns a hello message only for authenticated requests.

- Method: `hello.secure`

The service is currently configured with one user:

- Username: `admin`
- Password: `password`
