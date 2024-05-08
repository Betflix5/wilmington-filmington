import './footer.scss';

import React from 'react';

export const BrandIcon = props => (
  <div {...props} className="brand-icon">
    <a href="#">
      <img src="/content/images/icons8-linkedin-48.png" alt="LinkedIn Logo" />
    </a>
    <a href="#">
      <img src="/content/images/icons8-github-100.png" alt="Github Logo" style={{ width: '50px' }} />
    </a>
  </div>
);

const Footer = () => (
  <div className="footer">
    <div className="link-group">
      <div className="link-container">
        <a href="#">
          <line>About Us</line>
        </a>
        <a href="#">
          <line>Have Questions?</line>
        </a>
        <a href="#">
          <line>Watch Now</line>
        </a>
      </div>
      <div className="link-container">
        <a href="#">
          <line>Account</line>
        </a>
        <a href="#">
          <line>Register</line>
        </a>
        <a href="#">
          <line>Login</line>
        </a>
      </div>
    </div>
    <div>
      <BrandIcon />
    </div>
  </div>
);

export default Footer;
