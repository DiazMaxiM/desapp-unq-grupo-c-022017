interface AuthConfig {
  clientID: string;
  domain: string;
  callbackURL: string;
}

export const AUTH_CONFIG: AuthConfig = {
  clientID: 'QZyNQLkRUnw0VRHAIsiTp8MR4DkcuCD7',
  domain: 'maximilianodiaz.auth0.com',
  callbackURL: 'http://localhost:4200/user'
};
