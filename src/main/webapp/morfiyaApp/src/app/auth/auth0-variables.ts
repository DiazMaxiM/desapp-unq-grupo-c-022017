interface AuthConfig {
  clientID: string;
  domain: string;
  callbackURL: string;
}

export const AUTH_CONFIG: AuthConfig = {
  clientID: 'D0WbZaPsn4sk4RPC9G_i5bEV9SSkSWxd',
  domain: 'rosali-zaracho.auth0.com',
  callbackURL: 'http://localhost:4200/callback'
};
