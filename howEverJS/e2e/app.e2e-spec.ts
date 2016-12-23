import { HowEverJSPage } from './app.po';

describe('how-ever-js App', function() {
  let page: HowEverJSPage;

  beforeEach(() => {
    page = new HowEverJSPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
